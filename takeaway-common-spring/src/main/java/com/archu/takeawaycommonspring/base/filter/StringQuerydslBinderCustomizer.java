package com.archu.takeawaycommonspring.base.filter;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

/**
 * Interface provide option for use different filter operators in a REST search
 * via @QuerydslPredicate for String type fields.
 * The use of other search operators for types other than String is impossible due to the implementation of QueryDslArgumentResolver.
 */
public interface StringQuerydslBinderCustomizer<T extends EntityPath<?>> extends QuerydslBinderCustomizer<T> {

    @Override
    default void customize(final QuerydslBindings bindings, final T root) {
        bindings.bind(String.class)
                .all((path, values) ->
                        Optional.of(getPredicateForStringType(path, values)));
    }

    /**
     * Let to use in rest api these operators: eg. eq:somevalue
     * <p>
     * <p>
     * For String type:
     * <p>
     * StringExpression.like(java.lang.String)
     * StringExpression.notLike(java.lang.String)
     * StringExpression.notEqualsIgnoreCase(java.lang.String)
     * StringExpression.containsIgnoreCase(java.lang.String)
     * StringExpression.likeIgnoreCase(java.lang.String)
     * StringExpression.startsWithIgnoreCase(java.lang.String)
     * StringExpression.endsWithIgnoreCase(java.lang.String)
     * StringExpression.equalsIgnoreCase(java.lang.String)
     * StringExpression.startsWith(java.lang.String)
     * StringExpression.endsWith(java.lang.String)
     * StringExpression.matches(java.lang.String)
     * StringExpression.contains(java.lang.String)
     * StringExpression.isEmpty()
     * StringExpression.isNotEmpty()
     * SimpleExpression.isNull()
     * SimpleExpression.isNotNull()
     * SimpleExpression.ne(java.lang.Object)
     * SimpleExpression.eq(java.lang.Object)
     */
    private BooleanBuilder getPredicateForStringType(final Path<String> path, final Collection<? extends String> values) {
        final var predicate = new BooleanBuilder();
        values.forEach(
                input -> {
                    final var parts = input.split(":");
                    final var operator = parts[0];
                    final var value = parts.length > 1 ? parts[1] : null;
                    predicate.or(applyComparison(path, operator, value));
                });
        return predicate;
    }

    private <R> BooleanExpression applyComparison(final Path<R> path, final String operator, final R value) {
        try {
            final var method = Arrays.stream(path.getClass().getMethods())
                    .filter(m -> operator.equals(m.getName()))
                    .filter(m -> BooleanExpression.class.equals(m.getReturnType()))
                    .filter(m -> m.getParameterTypes().length == (value == null ? 0 : 1))
                    .filter(m -> value == null || m.getParameterTypes()[0].equals(value.getClass()) || m.getParameterTypes()[0].equals(Object.class))
                    .findFirst().orElseThrow(RuntimeException::new);

            return value == null
                    ? (BooleanExpression) method.invoke(path)
                    : (BooleanExpression) method.invoke(path, value);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }
}

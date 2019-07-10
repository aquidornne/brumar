package com.blumar.entity.criteria;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.NumberExpression;
import com.mysema.query.types.expr.StringExpression;

public final class CriteriaUtil {
	
	private CriteriaUtil() {
	}
	
	public static BooleanExpression buscaLike(StringExpression field, String expression) {
		return field.toLowerCase().like("%" + expression + "%");
	}
	
	public static BooleanExpression compararLong(NumberExpression<Long> field, Long id) {
		return field.eq(id);
	}

	public static BooleanExpression compararInt(NumberExpression<Integer> field, Integer id) {
		return field.eq(id);
	}
	
	public static BooleanExpression compararByte(NumberExpression<Byte> field, Byte id) {
		return field.eq(id);
	}
}

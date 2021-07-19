package app.clothesstore.productos.store.repositories.util;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class QueryBuilder {
	
	private static final String WHERE = " WHERE ";
	private static final String AND = " AND ";
	private static final String OR = " OR ";
	private static final String ORDER_BY = " ORDER BY ";
	private static final String LIMIT = " LIMIT ? ";
	private static final String OFFSET = " OFFSET ? ";
	
	private StringBuilder query;
	
	public QueryBuilder() {
		query = new StringBuilder();
	}
	
	public QueryBuilder setBaseQuery(String baseQuery) {
		query = query.append(baseQuery);
		return this;
	}
	
	public QueryBuilder where(String condition) {
		query = query.append(WHERE);
		query = query.append(condition);
		return this;
	}
	
	public QueryBuilder and(String condition) {
		query = query.append(AND);
		query = query.append(condition);
		return this;
	}
	
	public QueryBuilder or(String condition) {
		query = query.append(OR);
		query = query.append(condition);
		return this;
	}
	
	public QueryBuilder orderBy(String fields) {
		query = query.append(ORDER_BY);
		query = query.append(fields);
		return this;
	}
	
	public QueryBuilder offset() {
		query = query.append(OFFSET);
		return this;
	}
	
	public QueryBuilder limit() {
		query = query.append(LIMIT);
		return this;
	}
	
	public String toString() {
		return query.toString();
	}

}

package com.holding.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlaceholderrateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlaceholderrateExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLibraryidIsNull() {
            addCriterion("libraryId is null");
            return (Criteria) this;
        }

        public Criteria andLibraryidIsNotNull() {
            addCriterion("libraryId is not null");
            return (Criteria) this;
        }

        public Criteria andLibraryidEqualTo(Integer value) {
            addCriterion("libraryId =", value, "libraryid");
            return (Criteria) this;
        }

        public Criteria andLibraryidNotEqualTo(Integer value) {
            addCriterion("libraryId <>", value, "libraryid");
            return (Criteria) this;
        }

        public Criteria andLibraryidGreaterThan(Integer value) {
            addCriterion("libraryId >", value, "libraryid");
            return (Criteria) this;
        }

        public Criteria andLibraryidGreaterThanOrEqualTo(Integer value) {
            addCriterion("libraryId >=", value, "libraryid");
            return (Criteria) this;
        }

        public Criteria andLibraryidLessThan(Integer value) {
            addCriterion("libraryId <", value, "libraryid");
            return (Criteria) this;
        }

        public Criteria andLibraryidLessThanOrEqualTo(Integer value) {
            addCriterion("libraryId <=", value, "libraryid");
            return (Criteria) this;
        }

        public Criteria andLibraryidIn(List<Integer> values) {
            addCriterion("libraryId in", values, "libraryid");
            return (Criteria) this;
        }

        public Criteria andLibraryidNotIn(List<Integer> values) {
            addCriterion("libraryId not in", values, "libraryid");
            return (Criteria) this;
        }

        public Criteria andLibraryidBetween(Integer value1, Integer value2) {
            addCriterion("libraryId between", value1, value2, "libraryid");
            return (Criteria) this;
        }

        public Criteria andLibraryidNotBetween(Integer value1, Integer value2) {
            addCriterion("libraryId not between", value1, value2, "libraryid");
            return (Criteria) this;
        }

        public Criteria andLlibraryrateIsNull() {
            addCriterion("llibraryRate is null");
            return (Criteria) this;
        }

        public Criteria andLlibraryrateIsNotNull() {
            addCriterion("llibraryRate is not null");
            return (Criteria) this;
        }

        public Criteria andLlibraryrateEqualTo(Double value) {
            addCriterion("llibraryRate =", value, "llibraryrate");
            return (Criteria) this;
        }

        public Criteria andLlibraryrateNotEqualTo(Double value) {
            addCriterion("llibraryRate <>", value, "llibraryrate");
            return (Criteria) this;
        }

        public Criteria andLlibraryrateGreaterThan(Double value) {
            addCriterion("llibraryRate >", value, "llibraryrate");
            return (Criteria) this;
        }

        public Criteria andLlibraryrateGreaterThanOrEqualTo(Double value) {
            addCriterion("llibraryRate >=", value, "llibraryrate");
            return (Criteria) this;
        }

        public Criteria andLlibraryrateLessThan(Double value) {
            addCriterion("llibraryRate <", value, "llibraryrate");
            return (Criteria) this;
        }

        public Criteria andLlibraryrateLessThanOrEqualTo(Double value) {
            addCriterion("llibraryRate <=", value, "llibraryrate");
            return (Criteria) this;
        }

        public Criteria andLlibraryrateIn(List<Double> values) {
            addCriterion("llibraryRate in", values, "llibraryrate");
            return (Criteria) this;
        }

        public Criteria andLlibraryrateNotIn(List<Double> values) {
            addCriterion("llibraryRate not in", values, "llibraryrate");
            return (Criteria) this;
        }

        public Criteria andLlibraryrateBetween(Double value1, Double value2) {
            addCriterion("llibraryRate between", value1, value2, "llibraryrate");
            return (Criteria) this;
        }

        public Criteria andLlibraryrateNotBetween(Double value1, Double value2) {
            addCriterion("llibraryRate not between", value1, value2, "llibraryrate");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andRoomrateIsNull() {
            addCriterion("roomRate is null");
            return (Criteria) this;
        }

        public Criteria andRoomrateIsNotNull() {
            addCriterion("roomRate is not null");
            return (Criteria) this;
        }

        public Criteria andRoomrateEqualTo(Double value) {
            addCriterion("roomRate =", value, "roomrate");
            return (Criteria) this;
        }

        public Criteria andRoomrateNotEqualTo(Double value) {
            addCriterion("roomRate <>", value, "roomrate");
            return (Criteria) this;
        }

        public Criteria andRoomrateGreaterThan(Double value) {
            addCriterion("roomRate >", value, "roomrate");
            return (Criteria) this;
        }

        public Criteria andRoomrateGreaterThanOrEqualTo(Double value) {
            addCriterion("roomRate >=", value, "roomrate");
            return (Criteria) this;
        }

        public Criteria andRoomrateLessThan(Double value) {
            addCriterion("roomRate <", value, "roomrate");
            return (Criteria) this;
        }

        public Criteria andRoomrateLessThanOrEqualTo(Double value) {
            addCriterion("roomRate <=", value, "roomrate");
            return (Criteria) this;
        }

        public Criteria andRoomrateIn(List<Double> values) {
            addCriterion("roomRate in", values, "roomrate");
            return (Criteria) this;
        }

        public Criteria andRoomrateNotIn(List<Double> values) {
            addCriterion("roomRate not in", values, "roomrate");
            return (Criteria) this;
        }

        public Criteria andRoomrateBetween(Double value1, Double value2) {
            addCriterion("roomRate between", value1, value2, "roomrate");
            return (Criteria) this;
        }

        public Criteria andRoomrateNotBetween(Double value1, Double value2) {
            addCriterion("roomRate not between", value1, value2, "roomrate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
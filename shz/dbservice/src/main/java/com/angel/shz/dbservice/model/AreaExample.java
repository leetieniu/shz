package com.angel.shz.dbservice.model;

import java.util.ArrayList;
import java.util.List;

public class AreaExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table shz..area
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table shz..area
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table shz..area
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shz..area
     *
     * @mbggenerated
     */
    public AreaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shz..area
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shz..area
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shz..area
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shz..area
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shz..area
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shz..area
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shz..area
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shz..area
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shz..area
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shz..area
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table shz..area
     *
     * @mbggenerated
     */
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

        public Criteria andShengIsNull() {
            addCriterion("sheng is null");
            return (Criteria) this;
        }

        public Criteria andShengIsNotNull() {
            addCriterion("sheng is not null");
            return (Criteria) this;
        }

        public Criteria andShengEqualTo(String value) {
            addCriterion("sheng =", value, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengNotEqualTo(String value) {
            addCriterion("sheng <>", value, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengGreaterThan(String value) {
            addCriterion("sheng >", value, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengGreaterThanOrEqualTo(String value) {
            addCriterion("sheng >=", value, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengLessThan(String value) {
            addCriterion("sheng <", value, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengLessThanOrEqualTo(String value) {
            addCriterion("sheng <=", value, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengLike(String value) {
            addCriterion("sheng like", value, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengNotLike(String value) {
            addCriterion("sheng not like", value, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengIn(List<String> values) {
            addCriterion("sheng in", values, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengNotIn(List<String> values) {
            addCriterion("sheng not in", values, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengBetween(String value1, String value2) {
            addCriterion("sheng between", value1, value2, "sheng");
            return (Criteria) this;
        }

        public Criteria andShengNotBetween(String value1, String value2) {
            addCriterion("sheng not between", value1, value2, "sheng");
            return (Criteria) this;
        }

        public Criteria andShiIsNull() {
            addCriterion("shi is null");
            return (Criteria) this;
        }

        public Criteria andShiIsNotNull() {
            addCriterion("shi is not null");
            return (Criteria) this;
        }

        public Criteria andShiEqualTo(String value) {
            addCriterion("shi =", value, "shi");
            return (Criteria) this;
        }

        public Criteria andShiNotEqualTo(String value) {
            addCriterion("shi <>", value, "shi");
            return (Criteria) this;
        }

        public Criteria andShiGreaterThan(String value) {
            addCriterion("shi >", value, "shi");
            return (Criteria) this;
        }

        public Criteria andShiGreaterThanOrEqualTo(String value) {
            addCriterion("shi >=", value, "shi");
            return (Criteria) this;
        }

        public Criteria andShiLessThan(String value) {
            addCriterion("shi <", value, "shi");
            return (Criteria) this;
        }

        public Criteria andShiLessThanOrEqualTo(String value) {
            addCriterion("shi <=", value, "shi");
            return (Criteria) this;
        }

        public Criteria andShiLike(String value) {
            addCriterion("shi like", value, "shi");
            return (Criteria) this;
        }

        public Criteria andShiNotLike(String value) {
            addCriterion("shi not like", value, "shi");
            return (Criteria) this;
        }

        public Criteria andShiIn(List<String> values) {
            addCriterion("shi in", values, "shi");
            return (Criteria) this;
        }

        public Criteria andShiNotIn(List<String> values) {
            addCriterion("shi not in", values, "shi");
            return (Criteria) this;
        }

        public Criteria andShiBetween(String value1, String value2) {
            addCriterion("shi between", value1, value2, "shi");
            return (Criteria) this;
        }

        public Criteria andShiNotBetween(String value1, String value2) {
            addCriterion("shi not between", value1, value2, "shi");
            return (Criteria) this;
        }

        public Criteria andQuxianIsNull() {
            addCriterion("quxian is null");
            return (Criteria) this;
        }

        public Criteria andQuxianIsNotNull() {
            addCriterion("quxian is not null");
            return (Criteria) this;
        }

        public Criteria andQuxianEqualTo(String value) {
            addCriterion("quxian =", value, "quxian");
            return (Criteria) this;
        }

        public Criteria andQuxianNotEqualTo(String value) {
            addCriterion("quxian <>", value, "quxian");
            return (Criteria) this;
        }

        public Criteria andQuxianGreaterThan(String value) {
            addCriterion("quxian >", value, "quxian");
            return (Criteria) this;
        }

        public Criteria andQuxianGreaterThanOrEqualTo(String value) {
            addCriterion("quxian >=", value, "quxian");
            return (Criteria) this;
        }

        public Criteria andQuxianLessThan(String value) {
            addCriterion("quxian <", value, "quxian");
            return (Criteria) this;
        }

        public Criteria andQuxianLessThanOrEqualTo(String value) {
            addCriterion("quxian <=", value, "quxian");
            return (Criteria) this;
        }

        public Criteria andQuxianLike(String value) {
            addCriterion("quxian like", value, "quxian");
            return (Criteria) this;
        }

        public Criteria andQuxianNotLike(String value) {
            addCriterion("quxian not like", value, "quxian");
            return (Criteria) this;
        }

        public Criteria andQuxianIn(List<String> values) {
            addCriterion("quxian in", values, "quxian");
            return (Criteria) this;
        }

        public Criteria andQuxianNotIn(List<String> values) {
            addCriterion("quxian not in", values, "quxian");
            return (Criteria) this;
        }

        public Criteria andQuxianBetween(String value1, String value2) {
            addCriterion("quxian between", value1, value2, "quxian");
            return (Criteria) this;
        }

        public Criteria andQuxianNotBetween(String value1, String value2) {
            addCriterion("quxian not between", value1, value2, "quxian");
            return (Criteria) this;
        }

        public Criteria andXiangzhenIsNull() {
            addCriterion("xiangzhen is null");
            return (Criteria) this;
        }

        public Criteria andXiangzhenIsNotNull() {
            addCriterion("xiangzhen is not null");
            return (Criteria) this;
        }

        public Criteria andXiangzhenEqualTo(String value) {
            addCriterion("xiangzhen =", value, "xiangzhen");
            return (Criteria) this;
        }

        public Criteria andXiangzhenNotEqualTo(String value) {
            addCriterion("xiangzhen <>", value, "xiangzhen");
            return (Criteria) this;
        }

        public Criteria andXiangzhenGreaterThan(String value) {
            addCriterion("xiangzhen >", value, "xiangzhen");
            return (Criteria) this;
        }

        public Criteria andXiangzhenGreaterThanOrEqualTo(String value) {
            addCriterion("xiangzhen >=", value, "xiangzhen");
            return (Criteria) this;
        }

        public Criteria andXiangzhenLessThan(String value) {
            addCriterion("xiangzhen <", value, "xiangzhen");
            return (Criteria) this;
        }

        public Criteria andXiangzhenLessThanOrEqualTo(String value) {
            addCriterion("xiangzhen <=", value, "xiangzhen");
            return (Criteria) this;
        }

        public Criteria andXiangzhenLike(String value) {
            addCriterion("xiangzhen like", value, "xiangzhen");
            return (Criteria) this;
        }

        public Criteria andXiangzhenNotLike(String value) {
            addCriterion("xiangzhen not like", value, "xiangzhen");
            return (Criteria) this;
        }

        public Criteria andXiangzhenIn(List<String> values) {
            addCriterion("xiangzhen in", values, "xiangzhen");
            return (Criteria) this;
        }

        public Criteria andXiangzhenNotIn(List<String> values) {
            addCriterion("xiangzhen not in", values, "xiangzhen");
            return (Criteria) this;
        }

        public Criteria andXiangzhenBetween(String value1, String value2) {
            addCriterion("xiangzhen between", value1, value2, "xiangzhen");
            return (Criteria) this;
        }

        public Criteria andXiangzhenNotBetween(String value1, String value2) {
            addCriterion("xiangzhen not between", value1, value2, "xiangzhen");
            return (Criteria) this;
        }

        public Criteria andJiedaoIsNull() {
            addCriterion("jiedao is null");
            return (Criteria) this;
        }

        public Criteria andJiedaoIsNotNull() {
            addCriterion("jiedao is not null");
            return (Criteria) this;
        }

        public Criteria andJiedaoEqualTo(String value) {
            addCriterion("jiedao =", value, "jiedao");
            return (Criteria) this;
        }

        public Criteria andJiedaoNotEqualTo(String value) {
            addCriterion("jiedao <>", value, "jiedao");
            return (Criteria) this;
        }

        public Criteria andJiedaoGreaterThan(String value) {
            addCriterion("jiedao >", value, "jiedao");
            return (Criteria) this;
        }

        public Criteria andJiedaoGreaterThanOrEqualTo(String value) {
            addCriterion("jiedao >=", value, "jiedao");
            return (Criteria) this;
        }

        public Criteria andJiedaoLessThan(String value) {
            addCriterion("jiedao <", value, "jiedao");
            return (Criteria) this;
        }

        public Criteria andJiedaoLessThanOrEqualTo(String value) {
            addCriterion("jiedao <=", value, "jiedao");
            return (Criteria) this;
        }

        public Criteria andJiedaoLike(String value) {
            addCriterion("jiedao like", value, "jiedao");
            return (Criteria) this;
        }

        public Criteria andJiedaoNotLike(String value) {
            addCriterion("jiedao not like", value, "jiedao");
            return (Criteria) this;
        }

        public Criteria andJiedaoIn(List<String> values) {
            addCriterion("jiedao in", values, "jiedao");
            return (Criteria) this;
        }

        public Criteria andJiedaoNotIn(List<String> values) {
            addCriterion("jiedao not in", values, "jiedao");
            return (Criteria) this;
        }

        public Criteria andJiedaoBetween(String value1, String value2) {
            addCriterion("jiedao between", value1, value2, "jiedao");
            return (Criteria) this;
        }

        public Criteria andJiedaoNotBetween(String value1, String value2) {
            addCriterion("jiedao not between", value1, value2, "jiedao");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andNormalAddressIsNull() {
            addCriterion("normal_address is null");
            return (Criteria) this;
        }

        public Criteria andNormalAddressIsNotNull() {
            addCriterion("normal_address is not null");
            return (Criteria) this;
        }

        public Criteria andNormalAddressEqualTo(Integer value) {
            addCriterion("normal_address =", value, "normalAddress");
            return (Criteria) this;
        }

        public Criteria andNormalAddressNotEqualTo(Integer value) {
            addCriterion("normal_address <>", value, "normalAddress");
            return (Criteria) this;
        }

        public Criteria andNormalAddressGreaterThan(Integer value) {
            addCriterion("normal_address >", value, "normalAddress");
            return (Criteria) this;
        }

        public Criteria andNormalAddressGreaterThanOrEqualTo(Integer value) {
            addCriterion("normal_address >=", value, "normalAddress");
            return (Criteria) this;
        }

        public Criteria andNormalAddressLessThan(Integer value) {
            addCriterion("normal_address <", value, "normalAddress");
            return (Criteria) this;
        }

        public Criteria andNormalAddressLessThanOrEqualTo(Integer value) {
            addCriterion("normal_address <=", value, "normalAddress");
            return (Criteria) this;
        }

        public Criteria andNormalAddressIn(List<Integer> values) {
            addCriterion("normal_address in", values, "normalAddress");
            return (Criteria) this;
        }

        public Criteria andNormalAddressNotIn(List<Integer> values) {
            addCriterion("normal_address not in", values, "normalAddress");
            return (Criteria) this;
        }

        public Criteria andNormalAddressBetween(Integer value1, Integer value2) {
            addCriterion("normal_address between", value1, value2, "normalAddress");
            return (Criteria) this;
        }

        public Criteria andNormalAddressNotBetween(Integer value1, Integer value2) {
            addCriterion("normal_address not between", value1, value2, "normalAddress");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table shz..area
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table shz..area
     *
     * @mbggenerated
     */
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
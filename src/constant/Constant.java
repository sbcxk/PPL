package constant;

/**
 * 常亮
 */
public interface Constant {
	/**
	 * 用户未激活
	 */
	int USER_IS_NOT_ACTIVE = 0;
	
	
	/**
	 * 用户已激活
	 */
	int USER_IS_ACTIVE = 1;
	
	
	/**
	 * 记住用户名
	 */
	String SAVE_NAME ="ok";
	/**
	 * 热门商品
	 */
	int PRODUCT_IS_HOT = 1;

	/**
	 * 商品未下架
	 */
	int PRODUCT_IS_UP = 0;

	/**
	 * 商品已下架
	 */
	int PRODUCT_IS_DOWN = 1;

	/**
	 * 订单状态
	 */
	int order_weifukuan=0;
	int order_yifukuan=1;
	int order_yifahuo=2;
	int order_wancheng=3;

}

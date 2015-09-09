package tools.socket.req;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Date;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import android.app.Activity;
//import android.app.ActivityManager;
//import android.app.ActivityManager.RunningAppProcessInfo;
//import android.app.ActivityManager.RunningTaskInfo;
//import android.content.Context;
//import android.content.Intent;
//import android.content.res.Resources;
//import android.graphics.Typeface;
//import android.net.ConnectivityManager;
//import android.net.NetworkInfo;
//import android.support.v4.app.FragmentTabHost;
//import android.util.DisplayMetrics;
//import android.util.Log;
//import android.view.View;
//import android.view.View.MeasureSpec;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.view.ViewGroup.LayoutParams;
//import android.webkit.WebView;
//import android.widget.ListAdapter;
//import android.widget.ListView;
//import android.widget.TabWidget;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//import com.handmark.pulltorefresh.library.PullToRefreshListView;
//import com.upchina.R;
//import com.upchina.activity.StockAreaListActivity;
//import com.upchina.activity.StockHelper;
//import com.upchina.activity.StockListActivity;
//import com.upchina.activity.StockMainActivity;
//import com.upchina.activity.StockViewPagerActivity;
//import com.upchina.activity.StockWebActivity;
//import com.upchina.bohailive.activity.BohaiLiveActivity;
//import com.upchina.choose.ChooseActivity;
//import com.upchina.choose.ChooseListActivity;
//import com.upchina.choose.OneKeyChooseActivity;
//import com.upchina.choose.util.ChooseHelper;
//import com.upchina.data.Const;
//import com.upchina.day.DayActivity;
//import com.upchina.db.DBHelper;
//import com.upchina.decision.DecActivity;
//import com.upchina.entity.Quote;
//import com.upchina.find.Activity.EconomicCalendaActivity;
//import com.upchina.find.Activity.GSCJGActivity;
//import com.upchina.find.Activity.YMSAActivity;
//import com.upchina.fund.activity.FundFlowActivity;
//import com.upchina.openaccount.activity.PhoneCheckActivity;
//import com.upchina.personal.activity.PersonalCenterApp;
//import com.upchina.personal.activity.PersonalCenterLoginActivity;
//import com.upchina.personal.module.BP;
//import com.upchina.personal.module.MemberType;
//import com.upchina.personal.module.Rights;
//import com.upchina.personal.module.User;
//import com.upchina.research.RsActivity;
//import com.upchina.shareperfence.SharePerfenceUtil;
//import com.upchina.stockpool.activity.StockPoolHardenActivity;
//import com.upchina.stockpool.activity.StockPoolStubActivity;
//import com.upchina.stockpool.activity.StockPoolTradeActivity;
//import com.upchina.stockpool.activity.StockPoolWinActivity;
//import com.upchina.stocktrade.activity.StockTradeHomeActivity;
//import com.upchina.stocktrade.activity.StockTradeLoginActivity;
//import com.upchina.stocktrade.activity.StockTradeMainActivity;
//import com.upchina.stocktrade.util.TradeCons;
//import com.upchina.track.SuperiorActivity;
//import com.upchina.track.TrackActivity;
//import com.upchina.track.bean.EarningEntity;
//import com.upchina.track.util.TrackHelper;
//import com.upchina.trade.activity.TradeApplecation;
//import com.upchina.trade.activity.TradeMainActivity;
//import com.upchina.trade.dialog.AlertDialog;
//import com.upchina.trade.util.BlowFish;
//import com.upchina.trade.util.Constant;
//import com.upchina.trade.util.StringUtils;
//import com.upchina.util.DataUtils;
//import com.upchina.util.UIUtils;
//import com.upchina.util.UMengUtil;
//import com.upchina.view.LeadPageDialog;
//
public class StockUtils {
//	/**
//	 * 更新当前显示view状态
//	 * 
//	 * @param
//	 */
//	public static void upCurrectView(Context context, FragmentTabHost mtab, int position) {
//		for (int i = 0; i < mtab.getTabWidget().getChildCount(); i++) {
//			View view = mtab.getTabWidget().getChildAt(i);
//			View block = view.findViewById(R.id.tab_block);
//			TextView text = (TextView) view.findViewById(R.id.tab_title);
//			if (i == position) {
//				// 选中字体颜色大小
//				text.setTextColor(context.getResources().getColor(R.color.stock_font_check_color));
//				// text.setTextSize(context.getResources().getDimension(R.dimen.stock_tab_checked_font_size));
//				text.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));// 粗体
//				block.setVisibility(View.VISIBLE);
//			} else {
//				// 默认字体大小颜色
//				text.setTextColor(context.getResources().getColor(R.color.stock_font_uncheck_color));
//				// text.setTextSize(context.getResources().getDimension(R.dimen.stock_tab_unchecked_font_size));
//				text.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));// 正常
//				block.setVisibility(View.GONE);
//			}
//
//		}
//	}
//
//	public static void upCurrectView(Context context, FragmentTabHost mtab, int position, boolean showblack) {
//		for (int i = 0; i < mtab.getTabWidget().getChildCount(); i++) {
//			View view = mtab.getTabWidget().getChildAt(i);
//			View block = view.findViewById(R.id.tab_block);
//			TextView text = (TextView) view.findViewById(R.id.tab_title);
//			if (i == position) {
//				// 选中字体颜色大小
//				text.setTextColor(context.getResources().getColor(R.color.stock_font_check_color));
//				// text.setTextSize(context.getResources().getDimension(R.dimen.stock_tab_checked_font_size));
//				text.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));// 粗体
//				if (showblack) {
//					block.setVisibility(View.VISIBLE);
//				} else {
//					block.setVisibility(View.GONE);
//				}
//			} else {
//				// 默认字体大小颜色
//				text.setTextColor(context.getResources().getColor(R.color.stock_font_uncheck_color));
//				// text.setTextSize(context.getResources().getDimension(R.dimen.stock_tab_unchecked_font_size));
//				text.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));// 正常
//				block.setVisibility(View.GONE);
//			}
//
//		}
//	}
//
//	public static void upCurrectTab(Context context, TabWidget tagwidget, int position) {
//		for (int i = 0; i < tagwidget.getChildCount(); i++) {
//			View view = tagwidget.getChildAt(i);
//			View block = view.findViewById(R.id.tab_block);
//			TextView text = (TextView) view.findViewById(R.id.tab_title);
//			if (i == position) {
//				// 选中字体颜色大小
//				text.setTextColor(context.getResources().getColor(R.color.stock_font_check_color));
//				// text.setTextSize(context.getResources().getDimension(R.dimen.stock_tab_checked_font_size));
//				text.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));// 粗体
//				block.setVisibility(View.VISIBLE);
//			} else {
//				// 默认字体大小颜色
//				text.setTextColor(context.getResources().getColor(R.color.stock_font_uncheck_color));
//				// text.setTextSize(context.getResources().getDimension(R.dimen.stock_tab_unchecked_font_size));
//				text.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));// 正常
//				block.setVisibility(View.GONE);
//			}
//
//		}
//	}
//
//	/**
//	 * @functon 设置TAB样式
//	 * @param context
//	 * @param tabhost
//	 */
//	public static void setTabStyle(Context context, TabWidget tabwidget, boolean showboder, int heightdimen) {
//		// 设置tab样式
//		LayoutParams params = tabwidget.getLayoutParams();
//		params.height = (int) context.getResources().getDimension(heightdimen);
//		tabwidget.setLayoutParams(params);
//		if (showboder) {
//			tabwidget.setBackgroundResource(R.drawable.tab_boder);
//		} else {
//			tabwidget.setBackgroundResource(R.drawable.tab_bottom_line);
//		}
//	}
//
//	public static void setTabStyle(Context context, TabWidget tabwidget, int heightdimen) {
//		// 设置tab样式
//		LayoutParams params = tabwidget.getLayoutParams();
//		params.height = (int) context.getResources().getDimension(heightdimen);
//		tabwidget.setLayoutParams(params);
//		tabwidget.setBackgroundResource(R.drawable.tab_top_none_line);
//	}
//
//	/**
//	 * @function 获取屏的高度/宽度
//	 * @param activity
//	 * @return
//	 */
//	public static int[] getScreenParam(Activity activity) {
//		DisplayMetrics displaymetrics = new DisplayMetrics();
//		activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
//		int mHeight = displaymetrics.heightPixels;
//		int mWidth = displaymetrics.widthPixels;
//		return new int[] { mWidth, mHeight };
//	}
//
//	/**
//	 * @function 行情列表获取排序代码
//	 * @param position
//	 * @return
//	 */
//	public static short getSortNum(int position) {
//		short result = 0;
//		switch (position) {
//		case 0:
//			// 证券代码
//			result = StockHelper.ZQDM;
//			break;
//		case 1:
//			// 现价
//			result = StockHelper.ZJCJ;
//			break;
//		case 2:
//			// 涨幅
//			result = StockHelper.ZAF;
//			break;
//		case 3:
//			// 涨跌
//			result = StockHelper.QRSD;
//			break;
//		case 4:
//			// 换手率
//			result = StockHelper.J_HSL;
//			break;
//		case 5:
//			// 成交量
//			result = StockHelper.CJL;
//			break;
//		case 6:
//			// 总金额
//			result = StockHelper.CJJE;
//			break;
//		case 7:
//			// 昨收
//			result = StockHelper.ZRSP;
//			break;
//		case 8:
//			// 今开
//			result = StockHelper.JRKP;
//			break;
//		case 9:
//			// 最高
//			result = StockHelper.ZGCJ;
//			break;
//		case 10:
//			// 最低
//			result = StockHelper.ZDCJ;
//			break;
//		case 11:
//			// 均价
//			result = StockHelper.JUNJ;
//			break;
//		case 12:
//			// 市盈率 、持仓
//			result = StockHelper.SYL;
//			break;
//		case 13:
//			// 持仓差
//			result = StockHelper.SJ2;
//			break;
//		case 14:
//			// 作结
//			result = StockHelper.SJ1;
//			break;
//		case 15:
//			// 买
//			result = StockHelper.ZGJM;
//			break;
//		case 16:
//			// ，卖
//			result = StockHelper.ZDJM;
//			break;
//		case 17:
//			result = StockHelper.ZEF;
//			break;
//		case 18:
//			result = StockHelper.XS;
//			break;
//		default:
//			result = StockHelper.ZQJC;
//			break;
//		}
//		return result;
//	}
//
//	/**
//	 * 判断当前网咯是否连接
//	 * 
//	 * @return
//	 */
//	public static boolean isNetWorkConnected(Context context) {
//		try {
//			if (null != context) {
//				ConnectivityManager manger = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//				if (null != manger) {
//					NetworkInfo info = manger.getActiveNetworkInfo();
//					return (info != null && info.isConnected());
//				} else {
//					return false;
//				}
//			} else {
//				return false;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//
//	/**
//	 * @function 根据差值获取背景涨跌色
//	 * @param dval
//	 * @param color
//	 * @param normalcolor
//	 * @param risecolor
//	 * @param fallcolor
//	 * @return
//	 */
//	public static int getBgColor(float dval, int normalcolor, int risecolor, int fallcolor) {
//		int bgcolor = normalcolor;
//		if (dval > 0) {
//			// 涨
//			bgcolor = risecolor;
//		} else if (dval < 0) {
//			// 跌
//			bgcolor = fallcolor;
//		} else if (dval == 0) {
//			// 持平
//			bgcolor = normalcolor;
//		}
//		return bgcolor;
//	}
//
//	/**
//	 * list排序
//	 * 
//	 * @param lists
//	 * @param sorttype
//	 *            2倒叙 1正序
//	 * @param column
//	 *            0 涨幅 else now
//	 * @return
//	 */
//	public static ArrayList<Quote> sortCollection(ArrayList<Quote> lists, final int sorttype, final int column) {
//		try {
//
//			System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
//			Collections.sort(lists, new Comparator<Quote>() {
//
//				@Override
//				public int compare(Quote lhs, Quote rhs) {
//					float ldval = Float.valueOf(lhs.getChange());
//					float rdval = Float.valueOf(rhs.getChange());
//					if (column == 0) {
//						ldval = Float.valueOf(lhs.getChange());
//						rdval = Float.valueOf(rhs.getChange());
//					} else {
//						ldval = Float.valueOf(lhs.getNow());
//						rdval = Float.valueOf(rhs.getNow());
//					}
//					if (sorttype == 2) {
//						if (ldval > rdval) {
//							return -1;
//						} else if (ldval < rdval) {
//							return 1;
//						} else {
//							return 0;
//						}
//					} else {
//						if (ldval > rdval) {
//							return 1;
//						} else if (ldval < rdval) {
//							return -1;
//						} else {
//							return 0;
//						}
//					}
//
//				}
//			});
//		} catch (Exception e) {
//			Log.d("StockUtils", "sort排序异常..");
//		}
//		return lists;
//	}
//
//	/**
//	 * 市场分类分钟总数
//	 * 
//	 * @param markettype
//	 * @return
//	 */
//	public static String[][] getMarketTimeNum(int markettype) {
//		String[][] timearray = Const.TIMES_DEFALUT;
//		int wd = DataUtils.getWeekOfDate(new Date());
//		switch (markettype) {
//		case StockHelper.MARKET_TAG_DEFALUT:
//			// 沪深交易所
//			// if(wd==5){
//			// timearray=Const.TIMES_DEFALUT2;
//			// }
//			break;
//		case StockHelper.MARKET_TAG_CHINA_FUTURES:
//			// 中国金融期货交易所 IF/TF
//			timearray = Const.TIMES_FUTURES_CN;
//			break;
//		case StockHelper.MARKET_TAG_FUTURES_DL:
//			timearray = Const.TIMES_FUTURES_DL;
//			// 大连商品交易所
//			break;
//		case StockHelper.MARKET_TAG_FUTURES_DL2:
//			timearray = Const.TIMES_FUTURES_DL;
//			// 大连商品交易所(夜)
//			break;
//		case StockHelper.MARKET_TAG_SH_FUTURES:
//			timearray = Const.TIMES_FUTURES_SH2;
//			// 上海期货交易所
//			break;
//		case StockHelper.MARKET_TAG_SH_FUTURES2:
//			timearray = Const.TIMES_FUTURES_SH2;
//			// 上海期货交易所(夜)
//			break;
//		case StockHelper.MARKET_TAG_FUTURES_ZS:
//			timearray = Const.TIMES_FUTURES_ZZ;
//			// 郑州商品交易所
//			break;
//		case StockHelper.MARKET_TAG_SH_METAL:
//			timearray = Const.TIMES_METAL_SH;
//			// 上海黄金交易所
//			break;
//		case StockHelper.MARKET_TAG_GOODS_BOHAI:
//			if (wd == 1) {
//				timearray = Const.TIMES_BOHAI2;
//			} else {
//				timearray = Const.TIMES_BOHAI2;
//			}
//			// 渤海商品交易所
//			break;
//		case StockHelper.MARKET_TAG_TJ_METAL:
//			// 天津贵金属交易所 全部品种(铜除外)
//			if (wd == 1) {
//				timearray = Const.TIMES_METAL_TJ;
//			} else {
//				timearray = Const.TIMES_METAL_TJ2;
//			}
//			break;
//		case StockHelper.MARKET_TAG_TJ_METAL2:
//			// 天津贵金属交易所 全部品种(现货铜)
//			if (wd == 1) {
//				timearray = Const.TIMES_METAL_TJ;
//			} else {
//				timearray = Const.TIMES_METAL_TJ2;
//			}
//			break;
//		case StockHelper.MARKET_TAG_TJ_METAL3:
//			// 天津贵金属交易所 全部品种(现货铜(冬)
//			if (wd == 1) {
//				timearray = Const.TIMES_METAL_TJ;
//			} else {
//				timearray = Const.TIMES_METAL_TJ2;
//			}
//			break;
//		case StockHelper.MARKET_TAG_GJ_METAL:
//			timearray = Const.TIMES_METAL_GJ;
//			break;
//		}
//		return timearray;
//	}
//
//	/**
//	 * 市场 品种类型（交易时间）
//	 * 
//	 * @param grouptype
//	 * @return
//	 */
//	public static int getMarketType(int setcode, String code) {
//		int mtype = StockHelper.MARKET_TAG_DEFALUT;
//		switch (setcode) {
//		case Const.bhSetcode:
//			mtype = StockHelper.MARKET_TAG_GOODS_BOHAI;
//			break;
//		case Const.sjSetcode:
//			// 上海金
//			mtype = StockHelper.MARKET_TAG_SH_METAL;
//			break;
//		case Const.ldjSetcode:
//			// 伦敦金
//			mtype = StockHelper.MARKET_TAG_GJ_METAL;
//			break;
//		case Const.tjSetcode:
//			// 天津
//			mtype = StockHelper.MARKET_TAG_TJ_METAL;
//			break;
//		case Const.dySetcode:
//			mtype = StockHelper.MARKET_TAG_TJ_METAL;
//			break;
//		case Const.gdSetcode:
//			mtype = StockHelper.MARKET_TAG_TJ_METAL;
//			break;
//		case Const.sfSetcode:
//			// 股指期货
//			// 期货
//			String str1 = code.substring(0, 2).toUpperCase();
//			if (str1.equals("IF") || str1.equals("TF")) {
//				mtype = StockHelper.MARKET_TAG_CHINA_FUTURES;
//				break;
//			}
//			break;
//		case Const.scSetcode:
//			// 上海商品期货
//			String str = code.substring(0, 2).toUpperCase();
//			if (str.equals("BU") || str.equals("FU") || str.equals("HC") || str.equals("RB") || str.equals("RU") || str.equals("WR")) {
//				mtype = StockHelper.MARKET_TAG_SH_FUTURES;
//				break;
//			}
//			if (str.equals("AG") || str.equals("AL") || str.equals("AU") || str.equals("CU") || str.equals("PB") || str.equals("ZN")) {
//				mtype = StockHelper.MARKET_TAG_SH_FUTURES2;
//				break;
//			}
//			break;
//		case Const.dcSetcode:
//			// 大连商品期货
//			String code0 = code.substring(0, 1).toLowerCase();
//			String code1 = code.substring(0, 2).toLowerCase();
//			if (code0.equals("a") || code0.equals("b") || code0.equals("c") || code0.equals("i") || code0.equals("l") || code0.equals("m") || code0.equals("v") || code0.equals("y")
//					|| code1.equals("bb") || code1.equals("fb")) {
//				mtype = StockHelper.MARKET_TAG_FUTURES_DL;
//				break;
//			}
//			if (code0.equals("j") || code0.equals("p")) {
//				if (code1.equals("jd") || code1.equals("jm") || code1.equals("pp")) {
//					mtype = StockHelper.MARKET_TAG_FUTURES_DL;
//					break;
//				} else {
//					mtype = StockHelper.MARKET_TAG_FUTURES_DL2;
//					break;
//				}
//			}
//			break;
//		case Const.zcSetcode:
//			// 郑州商品期货
//			mtype = StockHelper.MARKET_TAG_FUTURES_ZS;
//			break;
//		}
//		return mtype;
//	}
//
//	/**
//	 * 获取类型分类
//	 * 
//	 * @param setcode
//	 * @param code
//	 * @return
//	 */
//	public static int getGroupType(int setcode, String code) {
//		try {
//			if (setcode == 7) {
//				// 渤海
//				return StockHelper.TAG_BOHAI;
//			}
//			if (setcode > 2 && setcode < 7) {
//				// 期货
//				return StockHelper.TAG_FUTURES;
//			}
//			if (setcode > 7 && setcode < 13) {
//				// 贵金属
//				return StockHelper.TAG_METAL;
//			}
//			if (isArea(setcode, code)) {// 板块
//				return StockHelper.TAG_HOT_AREA;
//			}
//			if (isIndex(setcode, code)) {
//				// 指数
//				return StockHelper.TAG_INDEX;
//			}
//			int type = getStockType(setcode, code);
//			if (type != Const.CODE_SZAG && type != Const.CODE_SZBG && type != Const.CODE_SHAG && type != Const.CODE_SHBG && type != Const.CODE_SZCY && type != Const.CODE_SZ300CY) {
//				// 基金其他
//				return StockHelper.TAG_FUND;
//			}
//		} catch (Exception e) {
//		}
//		return StockHelper.TAG_DEFALUT;
//	}
//
//	/**
//	 * @function 判断是否指数
//	 * @param setcode
//	 * @param code
//	 * @return
//	 */
//	public static boolean isIndex(int setcode, String code) {
//		long l = 0;
//		try {
//			l = Long.parseLong(code);
//		} catch (Exception e) {
//			return false;
//		}
//		if (setcode == Const.shSetcode) {
//			if (l > 999000l || l < 30l)
//				return true;
//			String str = code.substring(0, 3);
//			if (str.equals("777") || str.equals("778") || str.equals("779"))
//				return true;
//		} else {
//			String str = code.substring(0, 3);
//			if (str.equals("399"))
//				return true;
//		}
//		if (l >= 880000l && l < 885000l)
//			return true;
//		if (l >= 990000l && l < 994000l)
//			return true;
//		return false;
//	}
//
//	/**
//	 * 判断是否板块
//	 * 
//	 * @param setcode
//	 * @param code
//	 * @return
//	 */
//	public static boolean isArea(int setcode, String code) {
//		boolean isarea = false;
//		if (null == code)
//			return false;
//		String substr = code.substring(0, 4);
//		if (substr.equals("8800") || substr.equals("8810") || substr.equals("8820") || substr.equals("8821"))
//			isarea = true;
//		return isarea;
//	}
//
//	/**
//	 * @function 获取证券类型
//	 * @param setcode
//	 * @param code
//	 * @return
//	 */
//	public static int getStockType(int setcode, String code) {
//		int type = 0;
//		switch (setcode) {
//		case Const.bhSetcode:
//			type = Const.CODE_BH;
//			break;
//		case Const.szSetcode:
//			type = Const.CODE_SZOTHER;
//			if (code.substring(0, 3).equals("003")) {
//				return Const.CODE_SZSPEC;
//			}
//			if (code.substring(0, 3).equals("300")) {
//				return Const.CODE_SZ300CY;
//			}
//			String str = code.substring(0, 1);
//			if (str.equals("0")) {
//				String str1 = code.substring(1, 2);
//				if (str1.equals("0")) {
//					if (code.substring(2, 3).equals("2")) {
//						type = Const.CODE_SZCY;
//					} else {
//						type = Const.CODE_SZAG;
//					}
//				} else if (str1.equals("3")) {
//				} else if (str1.equals("8")) {
//					type = Const.CODE_SZQZ;
//				}
//			} else if (str.equals("1")) {
//				String str1 = code.substring(1, 2);
//				if (str1.equals("0")) {
//					type = Const.CODE_SZGZ;
//				} else if (str1.equals("1")) {
//					type = Const.CODE_SZZQ;
//				} else if (str1.equals("2")) {
//					type = Const.CODE_SZKZHZQ;
//				} else if (str1.equals("3")) {
//					type = Const.CODE_SZGZHG;
//				} else if (str1.equals("5")) {
//
//				} else if (str1.equals("6")) {
//					type = Const.CODE_KFJJ;
//				} else if (str1.equals("7")) {
//
//				} else if (str1.equals("8")) {
//					type = Const.CODE_SZJJ;
//				}
//			} else if (str.equals("2")) {
//				type = Const.CODE_SZBG;
//			} else if (str.equals("3")) {
//				if (code.substring(1, 2).equals("8")) {
//					type = Const.CODE_SZQZ;
//				}
//			} else if (str.equals("4")) {
//				String str1 = code.substring(1, 2);
//				if (str1.equals("0") || str1.equals("2") || str1.equals("3"))
//					type = Const.CODE_SB;
//			}
//			break;
//		case Const.shSetcode:
//			type = Const.CODE_SHOTHER;
//			String strsh = code.substring(0, 1);
//			if (strsh.equals("0")) {
//				if (Long.parseLong(code) > 999l)
//					type = Const.CODE_SHGZ;
//			} else if (strsh.equals("1")) {
//				if (code.substring(1, 2).equals("2")) {
//					type = Const.CODE_SHZQ;
//				} else {
//					type = Const.CODE_SHKZHZQ;
//				}
//			} else if (strsh.equals("2")) {
//				type = Const.CODE_SHGZHG;
//			} else if (strsh.equals("5")) {
//				if (code.substring(1, 2).equals("8")) {
//					type = Const.CODE_SHQZ;
//				} else {
//					type = Const.CODE_SHJJ;
//				}
//			} else if (strsh.equals("6")) {
//				type = Const.CODE_SHAG;
//			} else if (strsh.equals("7")) {
//				if (code.substring(1, 2).equals("0")) {
//					type = Const.CODE_SHQZ;
//				}
//				if (code.substring(1, 2).equals("5") || code.substring(1, 2).equals("7")) {
//					type = Const.CODE_SHGZ;
//				}
//			} else if (strsh.equals("9")) {
//				if (Long.parseLong(code) < 909000L)
//					type = Const.CODE_SHBG;
//			}
//			break;
//		}
//		return type;
//	}
//
//	/**
//	 * 根据code获取setcode
//	 * 
//	 * @param code
//	 * @return
//	 */
//	public static int getSetCode(String code) {
//		int setcode = 0;
//		int stocktype = StockUtils.getStockType(0, code);
//		if (stocktype == 9) {
//			setcode = 1;
//		}
//		return setcode;
//	}
//
//	/**
//	 * 
//	 * @param context
//	 * @param stocks
//	 * @param position
//	 * @param entity
//	 */
//	public static void startStock(Context context, ArrayList<Quote> stocks, int position) {
//		Intent intent = new Intent(context, StockViewPagerActivity.class);
//		if (null != stocks) {
//			intent.putExtra("stocklist", stocks);
//			intent.putExtra("position", position);
//		}
//		context.startActivity(intent);
//	}
//
//	public static void startStockSingle(Context context, String code, String setcode, int tag) {
//		Intent intent = new Intent(context, StockViewPagerActivity.class);
//		intent.putExtra(StockHelper.STOCK_CODE_TAG, code);
//		intent.putExtra(StockHelper.STOCK_SETCODE_TAG, setcode);
//		intent.putExtra("from", tag);
//		context.startActivity(intent);
//	}
//
//	/**
//	 * @function 设置listview 高度
//	 * @param adapter
//	 * @param listview
//	 */
//	public static void setListViewHeight(ListAdapter adapter, ListView listview) {
//		int totalHeight = 0;
//		for (int size = 0; size < adapter.getCount(); size++) {
//			View listItem = adapter.getView(size, null, listview);
//			listItem.measure(0, 0);
//			totalHeight += listItem.getMeasuredHeight();
//		}
//		ViewGroup.LayoutParams params = listview.getLayoutParams();
//
//		params.height = totalHeight + (listview.getDividerHeight() * (adapter.getCount() - 1));
//
//		listview.setLayoutParams(params);
//	}
//
//	public static int getPullListViewHeight(ListAdapter adapter, PullToRefreshListView listview) {
//		int totalHeight = 0;
//		for (int size = 0; size < adapter.getCount(); size++) {
//			View listItem = adapter.getView(size, null, listview);
//			// listItem.measure(0, 0);
//			listItem.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
//			totalHeight += listItem.getMeasuredHeight();
//		}
//		int height = totalHeight + (listview.getRefreshableView().getDividerHeight() * (adapter.getCount() - 1));
//		return height;
//	}
//
//	/**
//	 * 获取刷新时间
//	 * 
//	 * @param context
//	 * @return
//	 */
//	public static int getRefreshInterval(Context context) {
//		int result = 0;
//		ConnectivityManager manger = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//		NetworkInfo activeNetInfo = manger.getActiveNetworkInfo();
//		if (activeNetInfo != null && activeNetInfo.isConnected()) {
//			String type = activeNetInfo.getTypeName();
//			if (type.equalsIgnoreCase("WIFI")) {
//				result = SharePerfenceUtil.getInstance(context).getIntValue(SharePerfenceUtil.REFRESH_WIFI);
//			} else if (type.equalsIgnoreCase("MOBILE")) {
//				result = SharePerfenceUtil.getInstance(context).getIntValue(SharePerfenceUtil.REFRESH_3G);
//			}
//		}
//		return result;
//	}
//
//	public static void initHelper(Context context, int type) {
//		String[] imgarray = context.getResources().getStringArray(R.array.help_img_array);
//		String[] keyarray = context.getResources().getStringArray(R.array.help_sharePerfence_key);
//		SharePerfenceUtil sp = SharePerfenceUtil.getInstance(context);
//		int tag = sp.getIntValue(keyarray[type]);
//		if (tag != 1) {
//			Intent intent = new Intent(context, LeadPageDialog.class);
//			intent.putExtra("imgname", imgarray[type]);
//			intent.putExtra("keyname", keyarray[type]);
//			intent.putExtra("type", type);
//			context.startActivity(intent);
//		}
//	}
//
//	public static void btnClick(int type, Context mcontext, Object... obj) {
//		StockMainActivity mainactivity = null;
//		if (mcontext instanceof StockMainActivity)
//			mainactivity = (StockMainActivity) mcontext;
//		switch (type) {
//		case -2:
//			Intent webintent = new Intent(mcontext, StockWebActivity.class);
//			webintent.putExtra("murl", String.valueOf(obj[0]));
//			mcontext.startActivity(webintent);
//			break;
//		case 0:// 互动web显示界面
//			break;
//		case 1:// :自选
//			UMengUtil.onEvent(mcontext, "0102");
//			mainactivity.mTabHost.setCurrentTab(1);
//			break;
//		case 2:// 股票
//			UMengUtil.onEvent(mcontext, "0103");
//			StockHelper.CURRENTINDEX = 0;
//			mainactivity.mTabHost.setCurrentTab(2);
//			break;
//		case 3:// 渤海商品
//			UMengUtil.onEvent(mcontext, "0104");
//			// startStockList(19,
//			// getResources().getStringArray(R.array.more_goods_group)[0]);
//			StockHelper.CURRENTINDEX = 1;
//			mainactivity.mTabHost.setCurrentTab(2);
//			break;
//		case 4:// 贵金属
//			UMengUtil.onEvent(mcontext, "0105");
//			StockHelper.CURRENTINDEX = 2;
//			mainactivity.mTabHost.setCurrentTab(2);
//			break;
//		case 5:// 高手跟踪 , 股林高手
//			UMengUtil.onEvent(mcontext, "0106");
//			mcontext.startActivity(new Intent(mcontext, TrackActivity.class));
//			break;
//		case 5001:
//			UMengUtil.onEvent(mcontext, "0150");
//			mcontext.startActivity(new Intent(mcontext, TrackActivity.class));
//			break;
//		case 6:// 选股
//			UMengUtil.onEvent(mcontext, "0107");
//			mcontext.startActivity(new Intent(mcontext, ChooseActivity.class));
//			break;
//		case 6001:
//			startChooseList(mcontext.getResources().getStringArray(R.array.choose_rsgroup_titles)[0], ChooseHelper.TAG_ATTENTION, mcontext);
//			// 6001：机构关注最高
//			break;
//		case 6002:
//			UMengUtil.onEvent(mcontext, "0405");
//			startChooseList(mcontext.getResources().getStringArray(R.array.choose_rsgroup_titles)[1], ChooseHelper.TAG_RECOMMEND, mcontext);
//			// 6002：明细分析师荐股
//			break;
//		case 6003:
//			startChooseList(mcontext.getResources().getStringArray(R.array.choose_rsgroup_titles)[2], ChooseHelper.TAG_VALUATION, mcontext);
//			// 6003：估值空间最大
//			break;
//		case 6004:
//			UMengUtil.onEvent(mcontext, "0406");
//			startChooseList(mcontext.getResources().getStringArray(R.array.choose_positiongroup_titles)[0], ChooseHelper.TAG_FUND, mcontext);
//			// 6004：基金重仓
//			break;
//		case 6005:
//			startChooseList(mcontext.getResources().getStringArray(R.array.choose_positiongroup_titles)[1], ChooseHelper.TAG_SOCIALSECURITY, mcontext);
//			// 6005：社保重仓
//			break;
//		case 6006:
//			startChooseList(mcontext.getResources().getStringArray(R.array.choose_positiongroup_titles)[2], ChooseHelper.TAG_QFII, mcontext);
//			// 6006：QFII重仓
//			break;
//		case 6007:
//			mcontext.startActivity(new Intent(mcontext, OneKeyChooseActivity.class));
//			// 6007：一键选股
//			break;	
//		case 6008:
//			mcontext.startActivity(new Intent(mcontext, StockPoolHardenActivity.class));
//			// 6008：涨停尖兵
//			break;	
//		case 6009:
//			mcontext.startActivity(new Intent(mcontext, StockPoolStubActivity.class));
//			// 6009：短线狙击
//			break;	
//		case 6010:
//			UMengUtil.onEvent(mcontext, "0410");
//			mcontext.startActivity(new Intent(mcontext, StockPoolTradeActivity.class));
//			// 6010：操盘驱动
//			break;
//		case 6011:
//			UMengUtil.onEvent(mcontext, "0411");
//			mcontext.startActivity(new Intent(mcontext, StockPoolWinActivity.class));
//			// 6011：多赢驱动
//			break;	
//		case 7:// 研究院
//			UMengUtil.onEvent(mcontext, "0108");
//			mcontext.startActivity(new Intent(mcontext, RsActivity.class));
//			break;
//		case 8:// 发现
//			UMengUtil.onEvent(mcontext, "0109");
//			mainactivity.mTabHost.setCurrentTab(3);
//			break;
//		case 8001:
//			// 高手藏金阁
//			UMengUtil.onEvent(mcontext, "0402");
//			Intent intent = new Intent(mcontext, GSCJGActivity.class);
//			intent.putExtra("gs_type", 2);
//			mcontext.startActivity(intent);
//			break;
//		case 8002:
//			// 高手策略
//			UMengUtil.onEvent(mcontext, "0114");
//			Intent intents = new Intent(mcontext, GSCJGActivity.class);
//			intents.putExtra("gs_type", 1);
//			mcontext.startActivity(intents);
//			break;
//		case 8003:
//			UMengUtil.onEvent(mcontext, "0403");
//			Intent aIntent = new Intent(mcontext, YMSAActivity.class);
//			aIntent.putExtra("YMS", "a");
//			mcontext.startActivity(aIntent);
//			break;// ：高手云秒杀（A套餐）
//		case 8004:// ：高手云秒杀（B套餐）
//			UMengUtil.onEvent(mcontext, "0404");
//			Intent bIntent = new Intent(mcontext, YMSAActivity.class);
//			bIntent.putExtra("YMS", "b");
//			mcontext.startActivity(bIntent);
//			break;
//		case 8005:
//			// 财经日历
//			UMengUtil.onEvent(mcontext, "0405");
//			mcontext.startActivity(new Intent(mcontext, EconomicCalendaActivity.class));
//			break;
//		case 9:// 大盘指数
//			UMengUtil.onEvent(mcontext, "0110");
//			startStockList(11, mcontext.getResources().getString(R.string.stock_area_index), mcontext);
//			break;
//		case 10:// 热门板块
//			UMengUtil.onEvent(mcontext, "0111");
//			Intent areaintent = new Intent(mcontext, StockAreaListActivity.class);
//			areaintent.putExtra("name", mcontext.getResources().getStringArray(R.array.marketgrouptags)[0]);
//			mcontext.startActivity(areaintent);
//			break;
//		case 11:// 股指期货
//			UMengUtil.onEvent(mcontext, "0112");
//			startStockList(23, mcontext.getResources().getStringArray(R.array.more_futures_group)[0], mcontext);
//			break;
//		case 12:// 沪深基金
//			UMengUtil.onEvent(mcontext, "0113");
//			startStockList(9, mcontext.getResources().getStringArray(R.array.more_fund_group)[0], mcontext);
//			break;
//		case 13:// 渤海直播
//			UMengUtil.onEvent(mcontext, "0116");
//			mcontext.startActivity(new Intent(mcontext, BohaiLiveActivity.class));
//			break;
//		case 14:// 渤海交易
//			UMengUtil.onEvent(mcontext, "0115");
//			if (TradeApplecation.isONLINE()) {
//				Intent mIntent = new Intent(mcontext, TradeMainActivity.class);
//				mIntent.putExtra("CO_I", StockHelper.CODE_STR);
//				mcontext.startActivity(mIntent);
//			} else {
//				Intent mIntent = new Intent(Constant.TRADE_MAIN_ACTIVITY_ACTION);
//				mIntent.putExtra("CO_I", StockHelper.CODE_STR);
//				mcontext.startActivity(mIntent);
//			}
//			break;
//		case -1:// 股林高手选手
//			EarningEntity entity = (EarningEntity) obj[0];
//			Intent mintent = new Intent(mcontext, SuperiorActivity.class);
//			mintent.putExtra(TrackHelper.TRACK_FANS_NAME, entity.getUserName());
//			mintent.putExtra(TrackHelper.TRACK_PARAM_TRACETAG, entity.getTraceTag());
//			mcontext.startActivity(mintent);
//			break;
//		case -3:// 通知栏进入 股林高手选手
//			Intent mIntent = new Intent("com.upchina.message");
//			mIntent.putExtra(TrackHelper.TRACK_FANS_NAME, String.valueOf(obj[0]));
//			mIntent.putExtra(TrackHelper.TRACK_PARAM_TRACETAG, String.valueOf(obj[1]));
//			mIntent.putExtra("from", -1);
//			mcontext.sendOrderedBroadcast(mIntent, null);
//			break;
//		case 15:// 高层决策内参
//			UMengUtil.onEvent(mcontext, "0151");
//			Intent dintent = new Intent(mcontext, DecActivity.class);
//			dintent.putExtra("title", mcontext.getResources().getString(R.string.dec_title_name));
//			mcontext.startActivity(dintent);
//			break;
//		case 16:// 每日证券电讯
//			UMengUtil.onEvent(mcontext, "0152");
//			Intent intentday = new Intent(mcontext, DayActivity.class);
//			intentday.putExtra("title", mcontext.getResources().getString(R.string.day_title_name));
//			mcontext.startActivity(intentday);
//			break;
//		case 17:// 问卷调查
//			Toast.makeText(mcontext, "问卷调查", Toast.LENGTH_SHORT).show();
//			break;
//		case 18:
//			// 交易
//			if (TradeCons.CLIENT_INFO == null) {// 交易未登录
//				mcontext.startActivity(new Intent(mcontext, StockTradeLoginActivity.class));
//			} else {// 已登录过交易
//				TradeCons.YYB = TradeCons.CLIENT_INFO.getYYB();
//				Intent tradeMainIntent = new Intent(mcontext, StockTradeHomeActivity.class);
//				tradeMainIntent.putExtra("user", TradeCons.CLIENT_INFO);
//				mcontext.startActivity(tradeMainIntent);
//			}
//			break;
//		case 19:
//			// 未登录
//			if (PersonalCenterApp.getUSER() == null || mcontext.getResources().getString(R.string.person_login_prompt).equals(PersonalCenterApp.getUSER().getUid())) {
//				((Activity) mcontext).startActivityForResult(new Intent(mcontext, PersonalCenterLoginActivity.class), 100);
//				return;
//			}
//			// 开户
//			mcontext.startActivity(new Intent(mcontext, PhoneCheckActivity.class));
//			break;
//		case 20:
//			// 天贵交易
//			// BloomplusTradeV2.startTrade(mcontext);
//			break;
//		case 21:
//			// 广贵交易
//			String packageName = "com.revenco.goldtrade.activity";
//			if (UIUtils.isInstalled(mcontext, packageName)) {
//				Intent ggintent = mcontext.getPackageManager().getLaunchIntentForPackage(packageName);
//				mcontext.startActivity(ggintent);
//			} else {
//				SharePerfenceUtil sp = SharePerfenceUtil.getInstance(mcontext);
//				String downloadURL = sp.getStringValue(sp.GGJY_DOWNLOAD);
//				if(StringUtils.isNotEmpty(downloadURL)){
//					UIUtils.showDownloadDialog(mcontext, mcontext.getResources().getString(R.string.gd_trade_msg),downloadURL);
//				}else{
//					UIUtils.showDownloadDialog(mcontext, mcontext.getResources().getString(R.string.gd_trade_msg), mcontext.getResources().getString(R.string.gd_trade_download_url));
//				}
//			}
//			break;
//		case 22:
//			// 资金流向
//			UMengUtil.onEvent(mcontext, "0408");
//			Intent fundIntent = new Intent(mcontext, FundFlowActivity.class);
//			fundIntent.putExtra("TYPE", 0);
//			mcontext.startActivity(fundIntent);
//			break;
//		case 23:
//			// DDE决策
//			UMengUtil.onEvent(mcontext, "0409");
//			Intent ddeIntent = new Intent(mcontext, FundFlowActivity.class);
//			ddeIntent.putExtra("TYPE", 1);
//			mcontext.startActivity(ddeIntent);
//			break;
//		default:
//			Toast.makeText(mcontext, "未知操作", Toast.LENGTH_SHORT).show();
//			break;
//		}
//	}
//
//	public static void startChooseList(String str, int tag, Context mcontext) {
//		Intent intent = new Intent(mcontext, ChooseListActivity.class);
//		intent.putExtra("title", str);
//		intent.putExtra(ChooseHelper.TYPE_TAG, tag);
//		mcontext.startActivity(intent);
//	}
//
//	public static void startStockList(int setdomain, String name, Context mcontext) {
//		Intent intent = new Intent(mcontext, StockListActivity.class);
//		intent.putExtra(StockHelper.STOCK_LIST_TAG, StockHelper.MORE_LIST);
//		intent.putExtra("setdomain", setdomain);
//		intent.putExtra("name", name);
//		mcontext.startActivity(intent);
//	}
//
//	public static boolean isProessRunning(Context context, String proessName) {
//
//		boolean isRunning = false;
//		ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
//		List<RunningAppProcessInfo> lists = am.getRunningAppProcesses();
//		for (RunningAppProcessInfo info : lists) {
//			Log.i("Service2进程", "" + info.processName);
//			if (info.processName.equals(proessName)) {
//				isRunning = true;
//			}
//		}
//
//		return isRunning;
//	}
//
//	public static void updateLoginUser(Context context, User user) {
//		DBHelper.getInstance(context).deleteAllUser(context.getResources().getString(R.string.visitor_uid));
//		DBHelper.getInstance(context).deleteRight(user);
//		DBHelper.getInstance(context).deleteMemberType(user);
//		DBHelper.getInstance(context).deleteBP(user);
//
//		// 保存登录用户对应的权限
//		if (user.getRights() != null) {
//			for (Rights right : user.getRights()) {
//				right.setUser_id(String.valueOf(user.getUid()));
//				DBHelper.getInstance(context).saveRights(right);
//			}
//		}
//		// 保存登录用户对应的会员类型
//		if (user.getMt() != null) {
//			for (MemberType mt : user.getMt()) {
//				mt.setUser_id(String.valueOf(user.getUid()));
//				DBHelper.getInstance(context).saveMemberType(mt);
//			}
//		}
//		// 保存登录用户对应的积分
//		if (user.getBp() != null) {
//			for (BP bp : user.getBp()) {
//				bp.setUser_id(String.valueOf(user.getUid()));
//				DBHelper.getInstance(context).saveBP(bp);
//			}
//		}
//		// 保存用户信息
//		DBHelper.getInstance(context).saveUser(user);
//	}
//
//	/**
//	 * @报价货币
//	 * @return
//	 */
//	public static String getPriceUint(short setcode, String codestr) {
//		String result = "克";
//		if (setcode == Const.ldjSetcode) {
//			if (codestr.contains("XAU") || codestr.contains("XAG") || codestr.contains("XAP") || codestr.contains("XPD") || codestr.contains("5120") || codestr.contains("5121")
//					|| codestr.contains("5122") || codestr.contains("5123") || codestr.contains("5127") || codestr.contains("5128")) {
//				result = "盎司";
//			} else if (codestr.contains("5124") || codestr.contains("5125")) {
//				result = "港两";
//			} else if (codestr.contains("TWGD")) {
//				result = "台两";
//			} else if (codestr.contains("5131")) {
//				result = "千克";
//			}
//		} else if (setcode == Const.tjSetcode || setcode == Const.dySetcode || setcode == Const.gdSetcode) {
//			if (codestr.contains("Ag") || codestr.contains("Ni") || codestr.contains("GDAG")) {
//				result = "千克";
//			} else if (codestr.contains("Pt") || codestr.contains("Pd") || codestr.contains("GDPD") || codestr.contains("GDPT")) {
//				result = "克";
//			} else if (codestr.contains("Cu") || codestr.contains("Al") || codestr.contains("YDCL")) {
//				result = "吨";
//			}
//		} else if (setcode == Const.sjSetcode) {
//			if (codestr.contains("Ag999") || codestr.contains("Ag9999") || codestr.contains("AgT+D")) {
//				result = "千克";
//			} else {
//				result = "克";
//			}
//		}
//		return result;
//	}
//
//	/**
//	 * 获取报价货币
//	 * 
//	 * @param setcode
//	 * @param codestr
//	 * @return
//	 */
//	public static String getCurrency(short setcode, String codestr) {
//		String result = "人民币";
//		if (setcode == Const.ldjSetcode) {
//			if (codestr.contains("XAU") || codestr.contains("XAG") || codestr.contains("XAP") || codestr.contains("XPD") || codestr.contains("5120") || codestr.contains("5121")
//					|| codestr.contains("5122") || codestr.contains("5123") || codestr.contains("5127") || codestr.contains("5128")) {
//				result = "美元";
//			} else if (codestr.contains("5124") || codestr.contains("5125")) {
//				result = "港元";
//			} else if (codestr.contains("TWGD")) {
//				result = "新台币";
//			}
//		}
//		return result;
//	}
//
//	/**
//	 * 没有数据
//	 */
//	public static void errorShow(final WebView mWebView, String mCallbackName, String mMobFormid, String mFunid) {
//		StringBuffer param = new StringBuffer();
//		param.append("{\"ecode\":0,\"einfo\":\"\",\"num\":" + 0 + ",\"POS\":\"\",\"data\":[]}");
//		final String szJsFunc = "javascript:" + mCallbackName + "(\"" + mMobFormid + "\",\"" + mFunid + "\",\"" + 0 + "\",'" + param + "')";
//		mWebView.post(new Runnable() {
//
//			@Override
//			public void run() {
//				// mWebView.setLayoutParams(new
//				// LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
//				mWebView.loadUrl(szJsFunc);
//			}
//
//		});
//	}
//
//	/**
//	 * 网络错误
//	 */
//	public static void networkError(Context context, final WebView mWebView) {
//		int timeoutFlag = 1;
//		if (!StockUtils.isNetWorkConnected(context)) {
//			timeoutFlag = 2;
//		} else {
//			timeoutFlag = 1;
//		}
//		final String szJsFunc = "javascript:" + "dataTimeOut" + "(\"" + timeoutFlag + "\")";
//		mWebView.post(new Runnable() {
//
//			@Override
//			public void run() {
//				// mWebView.setLayoutParams(new
//				// LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
//				mWebView.loadUrl(szJsFunc);
//			}
//
//		});
//	}
//
//	/**
//	 * 判断两个日期是否是同一天
//	 * 
//	 * @param firstDate
//	 * @param secondDate
//	 * @return
//	 */
//	public static boolean areSameDay(long firstDate, long secondDate) {
//		long MS_OF_ONE_DAY = 8640000;
//		long l1 = firstDate / MS_OF_ONE_DAY;
//		long l2 = secondDate / MS_OF_ONE_DAY;
//		return l1 == l2;
//	}
//
//	/**
//	 * 登陆解析User
//	 * 
//	 * @param context
//	 * @param response
//	 * @param openid
//	 * @return
//	 */
//	public static User parseUser(Context context, String response, String pwd) {
//		Gson gson = new Gson();
//		User user = new User();
//		Map<String, Object> dataMap = gson.fromJson(response, new TypeToken<Map<String, Object>>() {
//		}.getType());
//		if (dataMap != null) {
//			Iterator<String> it = dataMap.keySet().iterator();
//			while (it.hasNext()) {
//				String key = it.next();
//				if (Constant.KEY_CID.equals(key)) {
//					user.setCid(dataMap.get(key).toString());
//				} else if (Constant.KEY_UT.equals(key)) {
//					user.setUt(dataMap.get(key).toString());
//				} else if (Constant.KEY_CER_TIME.equals(key)) {
//					user.setCer_time(dataMap.get(key).toString());
//				} else if (Constant.KEY_REG_TIME.equals(key)) {
//					user.setReg_time(dataMap.get(key).toString());
//				} else if (Constant.KEY_PLATFORM.equals(key)) {
//					user.setPlatform(dataMap.get(key).toString());
//				} else if (Constant.KEY_DV.equals(key)) {
//					user.setDv(dataMap.get(key).toString());
//				} else if (Constant.KEY_RESULT.equals(key)) {
//					if ("true".equals(dataMap.get(key).toString().toLowerCase())) {
//						user.setResult(true);
//					} else {
//						user.setResult(false);
//					}
//				} else if (Constant.KEY_CHECK_HB.equals(key)) {
//					user.setCheck_hb(dataMap.get(key).toString());
//				} else if (Constant.KEY_TOKEN.equals(key)) {
//					user.setToken(dataMap.get(key).toString());
//				} else if (Constant.KEY_CLIENT_ID.equals(key)) {
//					user.setClientID(dataMap.get(key).toString());
//				} else if (Constant.KEY_RIGHTS.equals(key)) {
//					if (dataMap.get(key).getClass().equals(String.class)) {
//						user.setRights(null);
//					} else if (dataMap.get(key).getClass().equals(ArrayList.class)) {
//						List<Rights> rights = new ArrayList<Rights>();
//						rights = gson.fromJson(dataMap.get(key).toString(), new TypeToken<List<Rights>>() {
//						}.getType());
//						user.setRights(rights);
//					}
//				} else if (Constant.KEY_BP.equals(key)) {
//					if (dataMap.get(key).getClass().equals(String.class)) {
//						user.setBp(null);
//					} else if (dataMap.get(key).getClass().equals(ArrayList.class)) {
//						List<BP> bp = new ArrayList<BP>();
//						bp = gson.fromJson(dataMap.get(key).toString(), new TypeToken<List<BP>>() {
//						}.getType());
//						user.setBp(bp);
//					}
//				} else if (Constant.KEY_MT.equals(key)) {
//					if (dataMap.get(key).getClass().equals(String.class)) {
//						user.setMt(null);
//					} else if (dataMap.get(key).getClass().equals(ArrayList.class)) {
//						List<MemberType> mt = new ArrayList<MemberType>();
//						mt = gson.fromJson(dataMap.get(key).toString(), new TypeToken<List<MemberType>>() {
//						}.getType());
//						user.setMt(mt);
//					}
//				} else if (Constant.KEY_ERR_CODE.equals(key)) {
//					user.setErr_code(dataMap.get(key).toString());
//				} else if (Constant.KEY_ERR_MSG.equals(key)) {// 3051
//					user.setErr_msg(dataMap.get(key).toString());
//				} else if (Constant.HQRTIME.equals(key)) {
//					user.setHqrtime(dataMap.get(key).toString());
//				} else if (Constant.T.equals(key)) {
//					user.setT(dataMap.get(key).toString());
//				} else if (Constant.RD.equals(key)) {
//					String rd = dataMap.get(key).toString();
//					if(pwd!=null){
//						user.setRd(BlowFish.decrypt(pwd.toLowerCase(), rd));// 三方登陆用openID作为key来进行bluefish解密;普通登陆用密码作为key来进行bluefish解密
//					}
//				} else if (Constant.HQRIGHTS.equals(key)) {
//					user.setHqrights(dataMap.get(key).toString());
//				} else if (Constant.UID.equals(key)) {
//					user.setUid(dataMap.get(key).toString());
//				} else if (Constant.NICKNAME.equals(key)) {
//					user.setNickname(dataMap.get(key).toString());
//				}
//			}
//			if ("3051".equals(user.getErr_code())) {
//				user.setErr_msg(context.getResources().getString(R.string.username_error1));
//			} else if ("3011".equals(user.getErr_code())) {
//				user.setErr_msg(context.getResources().getString(R.string.pwd_error1));
//			}
//		} else {
//			return null;
//		}
//		return user;
//	}
//
//	/**
//	 * PC版本: 金蝴蝶：28-3000 博惠版：3001 （3101-3200） 严林版：3002-3100 券商版：4001-4100
//	 * 金牡丹：5001-5100 渤海版：6001-6100 百川财富：7001-7100 环球投资：8001-8100（广贵版）
//	 * Android：9501-9600 IOS: 9001-9100
//	 * 
//	 * @return 0 游客/严林版/渤海版/券商版 1 金蝴蝶/百川财富 2 环球投资版 3 博惠版 4 Android 5 IOS
//	 */
//	public static int getUserCampaignIdGroupType() {
//		int campaignType = 0;
//		try {
//			User user = PersonalCenterApp.getUSER();
//			String dv = user.getDv();
//			int dvInt = 0;
//			if (StringUtils.isEmpty(dv)) {// 游客
//				dvInt = 0;
//			} else {// 其他
//				dvInt = (int) Double.parseDouble(dv);
//			}
//			if (dvInt == 0 || (dvInt >= 3002 && dvInt <= 3100) || (dvInt >= 6001 && dvInt <= 6100) || (dvInt >= 4001 && dvInt <= 4100)) {
//				// 游客/严林版/渤海版/券商版
//				campaignType = 0;
//			} else if ((dvInt >= 28 && dvInt <= 3000) || (dvInt >= 7001 && dvInt <= 7100) || (dvInt >= 5001 && dvInt <= 5100)) {
//				// 金蝴蝶/百川财富//金牡丹
//				campaignType = 1;
//			} else if (dvInt >= 8001 && dvInt <= 8100) {
//				// 环球投资版
//				campaignType = 2;
//			} else if (dvInt == 3001 || (dvInt >= 3101 && dvInt <= 3200)) {
//				// 博惠版
//				campaignType = 3;
//			} else if (dvInt >= 9501 && dvInt <= 9600) {
//				// Android
//				campaignType = 4;
//			} else if (dvInt >= 9001 && dvInt <= 9100) {
//				// IOS
//				campaignType = 5;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return campaignType;
//	}
//
//	/**
//	 * @function 涨跌停函数算法
//	 * @param name
//	 *            股票名称
//	 * @param setcode
//	 * @param code
//	 *            股票代码
//	 * @param tpflag
//	 *            精度
//	 * @param Close
//	 *            收盘价格
//	 * @param bUp
//	 *            是否涨/true=涨停 false=跌停
//	 * @return
//	 */
//	public static double GetTPPrice(String name, int setcode, String code, int tpflag, double Close, boolean bUp) {
//		double fRet = 100.0, fStep = 100.0, fUnit = 100.0;
//		if (tpflag == 3)
//			fUnit = 1000.0;
//		int Type = getStockType(setcode, code);
//		if (name.substring(0, 2).equals("ST") || name.substring(0, 3).equals("*ST")) {
//			if (bUp)
//				fStep = (int) (Close * 0.05 * fUnit + 0.5) / fUnit;
//			else
//				fStep = (int) (Close * 0.05 * fUnit + 0.05) / fUnit;
//			if (bUp)
//				fRet = (int) ((Close + fStep) * fUnit + 0.5) / fUnit;
//			else
//				fRet = (int) (Close * 0.95 * fUnit + 0.5) / fUnit;
//		} else if (name.substring(0, 2).equals("PT")) {
//			if (bUp)
//				fStep = (int) (Close * 0.05 * fUnit + 0.5) / fUnit;
//			else
//				fStep = (int) (Close * 0.05 * fUnit + 0.05) / fUnit;
//			if (bUp)
//				fRet = (int) ((Close + fStep) * fUnit + 0.5) / fUnit;
//			else
//				fRet = 0.0;
//		} else if (Type == Const.CODE_SB) {// 三板
//			if (bUp)
//				fStep = (int) (Close * 0.05 * fUnit + 0.5) / fUnit;
//			else
//				fStep = (int) (Close * 0.05 * fUnit + 0.05) / fUnit;
//			if (bUp)
//				fRet = (int) ((Close + fStep) * fUnit + 0.5) / fUnit;
//			else
//				fRet = (int) (Close * 0.95 * fUnit + 0.5) / fUnit;
//		} else if (Type == Const.CODE_SZQZ || Type == Const.CODE_SZGZ || Type == Const.CODE_SZZQ || Type == Const.CODE_SZKZHZQ || Type == Const.CODE_SZGZHG || Type == Const.CODE_SHQZ
//				|| Type == Const.CODE_SHGZ || Type == Const.CODE_SHZQ || Type == Const.CODE_SHKZHZQ || Type == Const.CODE_SHGZHG)// 国债等
//		{
//			fRet = 0.0;
//		} else // 其它
//		{
//			if (bUp)
//				fStep = (int) (Close * 0.10 * fUnit + 0.5) / fUnit;
//			else
//				fStep = (int) (Close * 0.10 * fUnit + 0.05) / fUnit;
//			if (bUp)
//				fRet = (int) ((Close + fStep) * fUnit + 0.5) / fUnit;
//			else
//				fRet = (int) (Close * 0.90 * fUnit + 0.5) / fUnit;
//		}
//		return fRet;
//	}
//
//	/**
//	 * 根据setcode获取市场
//	 * 
//	 * @param setcode
//	 * @return
//	 */
//	public static String getSetCodeMC(int setcode) {
//		String setCodeMC = "SZ";
//		switch (setcode) {
//		case 0:// 深圳
//			setCodeMC = "SZ";
//			break;
//		case 1:// 上海
//			setCodeMC = "SH";
//			break;
//		case 3:// 股指期货
//			setCodeMC = "SF";
//			break;
//		case 4:// 上海商品期货
//			setCodeMC = "SC";
//			break;
//		case 5:// 大连商品期货
//			setCodeMC = "DC";
//			break;
//		case 6:// 郑州商品期货
//			setCodeMC = "ZC";
//			break;
//		case 7:// 渤海商品
//			setCodeMC = "BH";
//			break;
//		case 8:// 上海金
//			setCodeMC = "SJ";
//			break;
//		case 9:// 伦敦金
//			setCodeMC = "LDJ";
//			break;
//		case 10:// 天津贵金属
//			setCodeMC = "TJ";
//			break;
//		case 11:// 大圆银泰
//			setCodeMC = "DYJ";
//			break;
//		case 12:// 广东贵金属
//			setCodeMC = "GDGJS";
//			break;
//
//		default:
//			break;
//		}
//
//		return setCodeMC;
//	}
//	
//	/**
//	 * 获取委托状态
//	 * 0 未报 可以 1 待报 不可以 2 已报 可以 3 已报待撤 不可以 4 部成待撤 不可以 5 部撤 不可以 6 已撤 不可以 7 部成
//	 * 可以 8 已成 不可以 9 废单 不可以 W 待确认 不可以
//	 * @param context
//	 * @param wtStatus
//	 * @return
//	 */
//	public static String getWTTP(Context context,String wtStatus){
//		String status = "";
//		Resources resource = context.getResources();
//		if ("0".equals(wtStatus)) {
//			status = resource.getString(R.string.trade_order_status_0);
//		} else if ("1".equals(wtStatus)) {
//			status = resource.getString(R.string.trade_order_status_1);
//		} else if ("2".equals(wtStatus)) {
//			status = resource.getString(R.string.trade_order_status_2);
//		} else if ("3".equals(wtStatus)) {
//			status = resource.getString(R.string.trade_order_status_3);
//		} else if ("4".equals(wtStatus)) {
//			status = resource.getString(R.string.trade_order_status_4);
//		} else if ("5".equals(wtStatus)) {
//			status = resource.getString(R.string.trade_order_status_5);
//		} else if ("6".equals(wtStatus)) {
//			status = resource.getString(R.string.trade_order_status_6);
//		} else if ("7".equals(wtStatus)) {
//			status = resource.getString(R.string.trade_order_status_7);
//		} else if ("8".equals(wtStatus)) {
//			status = resource.getString(R.string.trade_order_status_8);
//		} else if ("9".equals(wtStatus)) {
//			status = resource.getString(R.string.trade_order_status_9);
//		} else if ("w".equals(wtStatus)) {
//			status = resource.getString(R.string.trade_order_status_10);
//		}
//		return status;
//	} 
//
//	public static String getTopActivity(Activity context){
//		ActivityManager manager = (ActivityManager) context
//				.getSystemService(Context.ACTIVITY_SERVICE);
//		List<RunningTaskInfo> runningTaskInfos = manager.getRunningTasks(1);
//		if (runningTaskInfos != null)
//			return (runningTaskInfos.get(0).topActivity).toString();
//		else
//			return null;
//	}
//	
//	public static void tradeHandleSocketTimeoutException(final Context context,final Activity activity){
//		System.out.println("tradeHandleSocketTimeoutException====");
//		AlertDialog alertDialog = null;
//		String currentActivity = StockUtils.getTopActivity(activity);
//		String simpleActivityName = activity.getComponentName().getShortClassName();
//		if(currentActivity!=null && currentActivity.contains(simpleActivityName)){
//			if(alertDialog == null){
//				alertDialog = new AlertDialog(context).builder();
//				alertDialog.setMsg(context.getResources().getString(R.string.stock_trade_session_timeout));
//				alertDialog.setPositiveButton(
//						context.getResources().getString(
//								R.string.comfirm),
//								new OnClickListener() {
//							@Override
//							public void onClick(View v) {
//								activity.startActivity(new Intent(context,StockTradeLoginActivity.class));
//								activity.finish();
//							}
//						});
//				alertDialog.setCanceledOnTouchOutside(false);
//				alertDialog.show();
//			}
//		}else{
//			activity.finish();
//		}
//	}
//
	public static Object getReqid(short setdomain, String blockid) {
		// TODO Auto-generated method stub
		short result = 0 ; 
		if(null != blockid && !"".equals(blockid)){
			result = tools.socket.Const.REG_NEW_MBTSLIST_COL_NREQ ; 
		}else{
			if( setdomain > 48 && setdomain < 55){
				result = tools.socket.Const.REG_NEW_TTSLIST_COL_NREQ ; 
			}else if( ( setdomain > 35 && setdomain < 40 ) || (setdomain > 40 && setdomain < 44 ) ){
				result = tools.socket.Const.REG_NEW_MTTSLIST_COL_NREQ ; 
			}
		}
		return result;
	}
//	
//	
//	
}

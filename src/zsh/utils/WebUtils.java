package zsh.utils;

import org.apache.commons.beanutils.BeanUtils;
import java.util.Map;

/**
 * @author zsh
 * @create 2021-01-02-12:34
 */
public class WebUtils {
    /**
     * ��Map�е�ֵע�뵽��Ӧ��JavaBean�����С�
     * @param value
     * @param bean
     */
    public static <T> T copyParamToBean( Map value , T bean ){
        try {
            System.out.println("ע��֮ǰ��" + bean);
            /**
             * ����������Ĳ�����ע�뵽user������
             */
            BeanUtils.populate(bean, value);
            System.out.println("ע��֮��" + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    /**
     * ���ַ���ת����Ϊint���͵�����
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt,int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }


}

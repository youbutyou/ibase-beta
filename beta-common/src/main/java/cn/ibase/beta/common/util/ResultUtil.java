package cn.ibase.beta.common.util;


import cn.ibase.beta.common.dto.DataPage;
import cn.ibase.beta.common.dto.FormResult;
import cn.ibase.beta.common.info.ResultMessageEnum;

import java.text.MessageFormat;
import java.util.List;

/**
 * 备件结果信息返回
 * @author Binbin.Yang1
 * @date 2019-03-06
 */
public class ResultUtil {

    private ResultUtil(){

    }


    /**
     * 分页数据结果的返回 (正确)
     * @param list
     * @param total
     * @return
     */
    public static <T> DataPage<T> createRightDataPage(List<T> list, int total){
        return createDataPage(list,total,true, ResultMessageEnum.SYS_EXE_SUCCESS);
    }

    /**
     * 分页数据结果的返回 (异常信息)
     * @param list
     * @param total
     * @return
     */
    public static <T> DataPage<T> createErrorDataPage(List<T> list, int total, ResultMessageEnum resultEnum){
        return createDataPage(list,total, false,resultEnum);
    }

    /**
     * 创建分页返回数据对象
     * @param list
     * @param total
     * @param flag
     * @param resultEnum
     * @param <T>
     * @return
     */
    private static <T> DataPage<T> createDataPage(List<T> list, int total, boolean flag,ResultMessageEnum resultEnum){
        DataPage<T> data = new DataPage<>();
        data.setData(list);
        data.setTotal(total);
        data.setSuccess(flag);
        data.setState(resultEnum.getState());
        data.setMessage(resultEnum.getMsg());
        return data;
    }


    /**
     * 创建非分页接口返回数据信息（正确）
     * @param data
     * @param <T>
     * @return
     */
    public static <T> FormResult<T> createRightFormResult(T data){
        return createFormResult(data,true,ResultMessageEnum.SYS_EXE_SUCCESS);
    }
    /**
     * 创建非分页接口返回数据信息（正确）
     * 携带提示信息
     * @param data
     * @param <T>
     * @return
     */
    public static <T> FormResult<T> createRightFormResult(T data,ResultMessageEnum resultMessageEnum){
        return createFormResult(data,true,resultMessageEnum);
    }
    /**
     * 创建非分页接口返回数据信息（正确）
     * 携带提示信息
     * @param data
     * @param <T>
     * @return
     */
    public static <T> FormResult<T> createRightFormResult(T data,ResultMessageEnum resultMessageEnum,String message){
        return createFormResultWithParam(data,true,resultMessageEnum,message);
    }

    /**
     * 创建非分页接口返回数据信息（异常）
     * @param data
     * @param <T>
     * @return
     */
    public static <T> FormResult<T> createErrorFormResult(T data,ResultMessageEnum resultEnum){
        return createFormResult(data,false,resultEnum);
    }
    /**
     * 创建非分页接口返回数据信息（异常）
     * @param data
     * @param <T>
     * @return
     */
    public static <T> FormResult<T> createErrorFormResult(T data,Integer state,String message){
        FormResult<T> result = new FormResult<>();
        result.setData(data);
        result.setSuccess(false);
        result.setState(state);
        result.setMessage(message);
        return result;
    }

    /**
     * 创建非分页接口返回数据信息（异常）
     * @param data
     * @param <T>
     * @return
     */
    public static <T> FormResult<T> createErrorFormResultWithParam(T data,ResultMessageEnum resultEnum,String param){
        return createFormResultWithParam(data,false,resultEnum,param);
    }

    /**
     * 创建接口返回信息
     * @param data
     * @param flag
     * @param resultEnum
     * @param <T>
     * @return
     */
    private static <T> FormResult<T> createFormResult(T data,boolean flag,ResultMessageEnum resultEnum){
        FormResult<T> result = new FormResult<>();
        result.setData(data);
        result.setSuccess(flag);
        result.setState(resultEnum.getState());
        result.setMessage(resultEnum.getMsg());
        return result;
    }

    /**
     * 创建接口返回信息
     * @param data
     * @param flag
     * @param resultEnum
     * @param <T>
     * @return
     */
    private static <T> FormResult<T> createFormResultWithParam(T data,boolean flag,ResultMessageEnum resultEnum,String param){
        FormResult<T> result = new FormResult<>();
        result.setData(data);
        result.setSuccess(flag);
        result.setState(resultEnum.getState());
        result.setMessage(MessageFormat.format(resultEnum.getMsg(), param));
        return result;
    }
}

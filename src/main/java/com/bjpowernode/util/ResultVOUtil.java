package com.bjpowernode.util;

import com.bjpowernode.vo.ResultVO;

/**
 * @ClassName ResultVOUtil
 * @Description: TODO
 * @Author codemi@aliyun.com
 * @Date 2020/1/6
 **/
public class ResultVOUtil {

    public static ResultVO success(Object o){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(o);
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}

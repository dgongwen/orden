package com.dgw.orden.controller;
import com.dgw.orden.request.Parmpacking;
import com.dgw.orden.request.TorderRequest;
import com.dgw.orden.service.TorderService;
import com.dgw.orden.vo.TorderVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
public class TorderController {
    @Resource
    TorderService torderService;


    //创建订单
    @GetMapping("/addOrder")
    public Parmpacking<Integer> addOrder(@RequestBody TorderRequest order){
        int i = torderService.creatOrder(order);
        if(i>0){
            return Parmpacking.success(i);
        }else{
           return Parmpacking.error();
        }

    }

    //根据订单id查询最终订单,发送出去
    @GetMapping("/select")
    public Parmpacking<List<TorderVo>> select(@RequestParam long torderId) {
        List<TorderVo> torderVos = torderService.selectById(torderId);
        if(torderVos!=null){
            return Parmpacking.success(torderVos);
        }else{
            return Parmpacking.error();
        }
    }

}

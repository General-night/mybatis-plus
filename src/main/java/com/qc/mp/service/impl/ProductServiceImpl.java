package com.qc.mp.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qc.mp.entity.Product;
import com.qc.mp.mapper.ProductMapper;
import com.qc.mp.service.IProductService;
import org.springframework.stereotype.Service;

/**
 * @Author：MoneyOrange
 * @Date：2023/4/1/23:16
 */

@DS("slave_1")
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
}

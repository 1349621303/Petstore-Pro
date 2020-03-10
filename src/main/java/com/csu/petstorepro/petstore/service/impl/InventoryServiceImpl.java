package com.csu.petstorepro.petstore.service.impl;

import com.csu.petstorepro.petstore.entity.Inventory;
import com.csu.petstorepro.petstore.mapper.InventoryMapper;
import com.csu.petstorepro.petstore.service.IInventoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
@Service
public class InventoryServiceImpl extends ServiceImpl<InventoryMapper, Inventory> implements IInventoryService {

}

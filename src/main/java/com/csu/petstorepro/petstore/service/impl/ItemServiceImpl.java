package com.csu.petstorepro.petstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csu.petstorepro.petstore.entity.Item;
import com.csu.petstorepro.petstore.mapper.InventoryMapper;
import com.csu.petstorepro.petstore.mapper.ItemMapper;
import com.csu.petstorepro.petstore.service.IItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService
{
    @Resource
    private ItemMapper itemMapper;
    @Resource
    private InventoryMapper inventoryMapper;

    @Override
    public List<Item> getItemListByProduct(String productId) {
        return itemMapper.getItemListByProduct(productId);
    }

    @Override
    public Item getItemById(String itemId) {
        return itemMapper.selectById(itemId);
    }

    @Override
    public int insertItem(Item item) {
        return itemMapper.insert(item);
    }

    @Override
    public int deleteItem(String itemId) {
        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("itemid",itemId);
        return itemMapper.deleteByMap(columnMap);
    }

    @Override
    public int updateItem(Item item) {
        return itemMapper.update(item,new QueryWrapper<Item>().eq("itemid",item.getItemid()));
    }


    //判断是否有库存
    @Override
    public boolean isItemInStock(String itemId) {
        return inventoryMapper.selectById(itemId).getQty() > 0;
    }
}

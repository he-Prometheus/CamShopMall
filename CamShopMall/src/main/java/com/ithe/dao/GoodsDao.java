package com.ithe.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ithe.entity.Goods;

public interface GoodsDao extends JpaRepository<Goods, Integer>{
	
//	@Query("from Goods where goodsName like CONCAT(:goodsName,'%')")
	@Query("from Goods where goodsName like CONCAT('%', :goodsName,'%')")
	List<Goods> findByGoodsNameLike(@Param("goodsName") String goodsName);
	
	@Query(value = "select * from goods where user_goods_id =:id",nativeQuery=true)
	List<Goods> findGoodsByuserId(@Param("id") Integer id);

}

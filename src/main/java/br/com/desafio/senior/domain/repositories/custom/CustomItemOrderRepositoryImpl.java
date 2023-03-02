package br.com.desafio.senior.domain.repositories.custom;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.desafio.senior.domain.entities.ItemOrderEntity;
import br.com.desafio.senior.domain.entities.QItemOrderEntity;

@Repository
public class CustomItemOrderRepositoryImpl extends QuerydslRepositorySupport implements CustomItemOrderRepository {
	
	public CustomItemOrderRepositoryImpl() {
        super(ItemOrderEntity.class);
    }


	public List<ItemOrderEntity> findAllByOrderId(UUID uuId) {
		
	QItemOrderEntity itemOrder = QItemOrderEntity.itemOrderEntity;
	
	JPAQuery<ItemOrderEntity> query = getQuerydsl()
            .createQuery()
            .from(itemOrder)
            .where(itemOrder.order.id.eq(uuId))
            .select(itemOrder);	
		return query.fetch();
	}
	
}

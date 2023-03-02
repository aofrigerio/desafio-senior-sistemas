package br.com.desafio.senior.domain.repositories.custom;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import br.com.desafio.senior.domain.entities.ItemOrderEntity;
import br.com.desafio.senior.domain.entities.QItemOrderEntity;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class CustomItemOrderRepositoryImpl implements CustomItemOrderRepository {
	
	private final EntityManager entityManager;
		
	public List<ItemOrderEntity> findAllByOrderId(UUID uuId) {		
		QItemOrderEntity itemOrder = QItemOrderEntity.itemOrderEntity;	
		JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
			
			return queryFactory.selectFrom(itemOrder)
					.where(itemOrder.order.id.eq(uuId))
					.fetch();
	}
	
}

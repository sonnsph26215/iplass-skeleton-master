package storeApp.product.dao;

import java.util.List;

import org.iplass.mtp.ManagerLocator;
import org.iplass.mtp.entity.BinaryReference;
import org.iplass.mtp.entity.Entity;
import org.iplass.mtp.entity.EntityManager;
import org.iplass.mtp.entity.LoadOption;
import org.iplass.mtp.entity.UpdateOption;
import org.iplass.mtp.entity.query.From;
import org.iplass.mtp.entity.query.Limit;
import org.iplass.mtp.entity.query.Query;
import org.iplass.mtp.entity.query.condition.Condition;

public abstract class EntityDaoHelper {
	
	private static final EntityManager em = ManagerLocator.getInstance().getManager(EntityManager.class);
	
	public static <T extends Entity> List<T> searchDistinctEntity(String definitinoName, Condition condition, String... properties) {
		return EntityDaoHelper.searchEntity(true, definitinoName, condition, null, properties);
	}

	@SuppressWarnings("unchecked")
	public static <T extends Entity> T load(String definitionName, String oid) {
		LoadOption option = new LoadOption();
		option.setLocalized(true);
		return (T) em.load(oid, definitionName, option);
	}
	
	public static <T extends Entity> List<T> searchDistinctEntity(String definitinoName, Condition condition, Limit limit,
			String... properties) {
		return EntityDaoHelper.searchEntity(true, definitinoName, condition, limit, properties);
	}
	
	@SuppressWarnings("unchecked")
	private static <T extends Entity> List<T> searchEntity(boolean distinct, String definitionName, Condition condition, Limit limit,
			String... properties) {
		Query query = new Query();
		if (definitionName == null) {
			throw new IllegalArgumentException("must specify definition name of entity.");
		} else {
			query.setFrom(new From(definitionName));
		}
		if (condition != null) {
			query.where(condition);
		}
		if (limit != null) {
			query.setLimit(limit);
		}
		if (properties != null && properties.length > 0) {
			if (distinct) {
				query.selectDistinct((Object[]) properties);
			} else {
				query.select((Object[]) properties);
			}
		} else {
			query.selectAll(definitionName, distinct, true);
		}
		//　言語フラグをtrueにする
		query.setLocalized(true);
		return (List<T>) em.searchEntity(query).getList();
	}
	
	public static int countDistinct(String definitionName, Condition condition) {
		Query query = new Query();
		query.selectDistinct(Entity.OID);
		if (definitionName == null) {
			throw new IllegalArgumentException("must specify definition name of entity.");
		} else {
			query.setFrom(new From(definitionName));
		}
		if (condition != null) {
			query.where(condition);
		}
		//　言語フラグをtrueにする
		query.setLocalized(true);
		return em.count(query);
	}
	
	public static BinaryReference loadBinaryReference(long lobId) {
		return em.loadBinaryReference(lobId);
	}
	
	public static String insert(Entity entity) {
		return em.insert(entity);
	}
	
	public static void update(Entity entity, UpdateOption option) {
		em.update(entity, option);
	}
	
}

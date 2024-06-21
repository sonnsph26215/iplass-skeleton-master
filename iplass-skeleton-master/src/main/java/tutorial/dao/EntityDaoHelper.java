package tutorial.dao;

import java.util.List;

import org.iplass.mtp.ManagerLocator;
import org.iplass.mtp.entity.BinaryReference;
import org.iplass.mtp.entity.Entity;
import org.iplass.mtp.entity.EntityManager;
import org.iplass.mtp.entity.LoadOption;
import org.iplass.mtp.entity.query.From;
import org.iplass.mtp.entity.query.Query;

public abstract class EntityDaoHelper {

private static final EntityManager em = ManagerLocator.getInstance().getManager(EntityManager.class);
	
	public static <T extends Entity> List<T> searchDistinctEntity(String definitionName, String... properties) {
		return EntityDaoHelper.searchEntity(definitionName, properties);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Entity> T load(String definitionName, String oid) {
		LoadOption option = new LoadOption();
		option.setLocalized(true);
		return (T) em.load(oid, definitionName, option);
	}
	
	@SuppressWarnings("unchecked")
	private static <T extends Entity> List<T> searchEntity(String definitionName, String... properties) {
		Query query = new Query();
		if (definitionName == null) {
			throw new IllegalArgumentException("must specify definition name of entity.");
		} else {
			query.setFrom(new From(definitionName));
		}
		if (properties != null && properties.length > 0) {
				query.select((Object[]) properties);
		} else {
			query.selectAll(definitionName,true, true);
		}
		//　言語フラグをtrueにする
		query.setLocalized(true);
		return (List<T>) em.searchEntity(query).getList();
	}
	
	public static BinaryReference loadBinaryReference(long lobId) {
		return em.loadBinaryReference(lobId);
	}
	
}

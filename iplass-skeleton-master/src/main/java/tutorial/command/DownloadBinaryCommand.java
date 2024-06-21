package tutorial.command;

import java.util.HashMap;
import java.util.Map;

import org.iplass.gem.command.Constants;
import org.iplass.mtp.command.Command;
import org.iplass.mtp.command.RequestContext;
import org.iplass.mtp.command.annotation.CommandClass;
import org.iplass.mtp.command.annotation.action.ActionMapping;
import org.iplass.mtp.command.annotation.action.Result;
import org.iplass.mtp.command.annotation.action.Result.Type;
import org.iplass.mtp.entity.BinaryReference;

import tutorial.dao.EntityDaoHelper;
import tutorial.entity.Product;


@ActionMapping(
		name = "tutorial/resource/bin", 
		displayName = "バイナリデータダウロード",
		privilaged = true,
		result = @Result(
				type = Type.STREAM, 
				value = DownloadBinaryCommand.RESULT_STREAM))
@CommandClass(
		name = "tutorial/resource/DownloadBinaryCommand", 
		displayName = "バイナリデータDLコマンド")
public class DownloadBinaryCommand implements Command {

	private final String PARAM_ID = "id";
	private final String PARAM_TYPE = "type";
	public static final String RESULT_STREAM = "resultStream";
	@SuppressWarnings("serial")
	private final Map<String, DefinitionPropName> defPropNameMap = new HashMap<String, DefinitionPropName>() {
		{
			put("image", new DefinitionPropName(Product.DEFINITION_NAME, Product.IMAGE));
		}
	};

	@Override
	public String execute(RequestContext request) {
		Long lobId = request.getParamAsLong(PARAM_ID);
		String type = request.getParam(PARAM_TYPE);

		DefinitionPropName defPropName = defPropNameMap.get(type);
		if (defPropName == null) {
			return Constants.CMD_EXEC_SUCCESS;
		}
		String defName = defPropName.getDefinitionName();
		String propName = defPropName.getPropertyName();
		BinaryReference br = EntityDaoHelper.loadBinaryReference(lobId);
		if (br != null && defName.equals(br.getDefinitionName()) && propName.equals(br.getPropertyName())) {
			request.setAttribute(RESULT_STREAM, br);
		} else {
			request.setAttribute(RESULT_STREAM, request.getSession().loadFromTemporary(lobId));
		}

		return Constants.CMD_EXEC_SUCCESS;
	}
	
	private class DefinitionPropName {
		private String definitionName;
		private String PropertyName;

		public DefinitionPropName(String definitionName, String propertyName) {
			this.definitionName = definitionName;
			this.PropertyName = propertyName;
		}

		public String getDefinitionName() {
			return definitionName;
		}

		public String getPropertyName() {
			return PropertyName;
		}
	}
	
}

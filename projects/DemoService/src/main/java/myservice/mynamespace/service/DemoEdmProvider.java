package myservice.mynamespace.service;

import java.util.List;

import org.apache.olingo.commons.api.edm.FullQualifiedName;
import org.apache.olingo.commons.api.edm.provider.CsdlAbstractEdmProvider;
import org.apache.olingo.commons.api.edm.provider.CsdlEntityContainer;
import org.apache.olingo.commons.api.edm.provider.CsdlEntityContainerInfo;
import org.apache.olingo.commons.api.edm.provider.CsdlEntitySet;
import org.apache.olingo.commons.api.edm.provider.CsdlEntityType;
import org.apache.olingo.commons.api.edm.provider.CsdlSchema;
import org.apache.olingo.commons.api.ex.ODataException;

public class DemoEdmProvider extends CsdlAbstractEdmProvider {

	public static final String NAMESPACE = "OData.Demo";
	
	public static final String CONTAINER_NAME = "Container";
	public static final FullQualifiedName CONTAINER = new FullQualifiedName(NAMESPACE, CONTAINER_NAME);
	
	public static final String ET_PRODUCT_NAME = "Product";
	public static final FullQualifiedName ET_PRODUCT_FQN =new FullQualifiedName(NAMESPACE, ET_PRODUCT_NAME);
	
	public static final String ES_PRODUCTS_NAME = "Products";

	
	@Override
	public CsdlEntityContainer getEntityContainer() throws ODataException {
		// TODO Auto-generated method stub
		return super.getEntityContainer();
	}

	@Override
	public CsdlEntityContainerInfo getEntityContainerInfo(
			FullQualifiedName entityContainerName) throws ODataException {
		// TODO Auto-generated method stub
		return super.getEntityContainerInfo(entityContainerName);
	}

	@Override
	public CsdlEntitySet getEntitySet(FullQualifiedName entityContainer,
			String entitySetName) throws ODataException {
		// TODO Auto-generated method stub
		return super.getEntitySet(entityContainer, entitySetName);
	}

	@Override
	public CsdlEntityType getEntityType(FullQualifiedName entityTypeName)
			throws ODataException {
		// TODO Auto-generated method stub
		return super.getEntityType(entityTypeName);
	}

	@Override
	public List<CsdlSchema> getSchemas() throws ODataException {
		// TODO Auto-generated method stub
		return super.getSchemas();
	}

}

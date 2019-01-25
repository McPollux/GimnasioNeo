package objetos;

import java.math.BigDecimal;

import org.neodatis.odb.OID;
import org.neodatis.odb.core.layers.layer2.meta.AttributeValuesMap;
import org.neodatis.odb.core.query.execution.IQueryFieldAction;
import org.neodatis.odb.impl.core.query.values.CustomQueryFieldAction;
import org.neodatis.odb.impl.core.query.values.MaxValueAction;
import org.neodatis.odb.impl.core.query.values.ValuesUtil;

public class TestCustomQueryFieldAction extends CustomQueryFieldAction {

    private BigDecimal maxValue;
    private OID oidOfMaxValues;

    public TestCustomQueryFieldAction(String attributeName, String alias) {
        this.maxValue = new BigDecimal(Long.MIN_VALUE);
        this.oidOfMaxValues = null;
    }


    public void execute(OID oid, AttributeValuesMap values) {
        Number n = (Number) values.get(attributeName);
        BigDecimal bd = ValuesUtil.convert(n);
        if(bd.compareTo(maxValue)>0){
            oidOfMaxValues = oid;
            maxValue = bd;
        }
    }


    public Object getValue() {
        return maxValue;
    }


    public void end() {
        // nothing to do
    }

    public void start() {
        // Nothing to do
    }

    public OID getOidOfMaxValues() {
        return oidOfMaxValues;
    }

    public IQueryFieldAction copy() {
        return new MaxValueAction(attributeName,alias);
    }
}
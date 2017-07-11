package org.example.demo.hibernate.tools;

import org.hibernate.cfg.reveng.DelegatingReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;

public class ReverseEngineering extends DelegatingReverseEngineeringStrategy {
    public ReverseEngineering(ReverseEngineeringStrategy delegate) {
        super(delegate);
    }

    @Override
    public String getTableIdentifierStrategyName(TableIdentifier tableIdentifier) {
        return "increment";
    }

    public String tableToClassName(TableIdentifier tableIdentifier) {
        String prefix = "tb_";
        if (tableIdentifier.getName().toLowerCase().startsWith(prefix)) {
            String className = super.tableToClassName(tableIdentifier);
            return getClassName(className, prefix);
        } else {
            return super.tableToClassName(tableIdentifier);
        }
    }

    private static String getClassName(String className, String prefix) {
        int i = className.lastIndexOf('.');
        if (i == -1) {
            return className.substring(prefix.length() - 1);
        }
        String packagee = className.substring(0, i + 1);
        String clazz = className.substring(i + 1);
        if (clazz.toLowerCase().startsWith(prefix.substring(0, prefix.length() - 1).toLowerCase())) {
            // 去掉前缀，没有 _ ，所以只需要去掉 prefix.length()-1 个字符即可
            clazz = className.substring(i + prefix.length());
        }
        return packagee + clazz;
    }
}

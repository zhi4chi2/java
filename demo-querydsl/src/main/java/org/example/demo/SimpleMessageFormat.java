package org.example.demo;

import com.p6spy.engine.common.P6Util;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

public class SimpleMessageFormat implements MessageFormattingStrategy {
    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql) {
        if (sql == null || sql.trim().isEmpty()) {
            return P6Util.singleLine(prepared);
        } else {
            return P6Util.singleLine(sql);
        }
    }
}

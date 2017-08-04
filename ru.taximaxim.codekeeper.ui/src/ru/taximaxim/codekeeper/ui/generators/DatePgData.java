package ru.taximaxim.codekeeper.ui.generators;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * An implementation of a PostgreSql data generator for DATE type.
 *
 * @since 3.11.5
 * @author galiev_mr
 */
public class DatePgData extends PgData {

    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    public String generateValue() {
        switch (generator) {
        case CONSTANT: return start;
        case INCREMENT:
            Long current = Timestamp.valueOf(currentInc).getTime();
            currentInc = format.format(new Date(current + Long.valueOf(step) * 1000));
            return "'" + format.format(new Date(current))+ "'";
        case RANDOM: return generateRandom();
        default:
            // throw new Exception("Unsupported format");
            return null;
        }
    }

    private String generateRandom() {
        Long beginTime = Timestamp.valueOf(start).getTime();
        Long endTime = Timestamp.valueOf(end).getTime();
        if (!isUnique && !isNotNull && ran.nextDouble() < 0.1) {
            return null;
        }
        while (true) {
            String object = "'" + format.format(new Date(beginTime + (long)(Math.random() * (endTime - beginTime + 1)))) + "'";
            if (!isUnique || objects.add(object)){
                return object;
            }
        }
    }

    @Override
    public int getMaxValues() {
        Long beginTime = Timestamp.valueOf(start).getTime();
        Long endTime = Timestamp.valueOf(end).getTime();
        return (int)((endTime - beginTime + 1) / 1000);
    }
}

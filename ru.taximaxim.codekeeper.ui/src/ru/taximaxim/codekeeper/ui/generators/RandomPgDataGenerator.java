package ru.taximaxim.codekeeper.ui.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class RandomPgDataGenerator extends PgDataGenerator {

    private final SecureRandom ran = new SecureRandom();

    public RandomPgDataGenerator() {
        super();
    }

    @Override
    protected Object generateCharacter() {
        return "'" + genString(genLong(Long.parseLong(column.getBegin()),
                Long.parseLong(column.getEnd())), false, ran, true) + "'";
    }

    @Override
    protected Object generateDate() {
        Long beginTime = Timestamp.valueOf(column.getBegin()).getTime();
        Long endTime = Timestamp.valueOf(column.getEnd()).getTime();
        return "'" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
                .format(new Date(genLong(beginTime, endTime))) + "'";
    }

    @Override
    protected Object generateInteger() {
        BigInteger bigEnd = new BigInteger(column.getEnd());
        BigInteger bigStart = new BigInteger(column.getBegin());
        BigInteger aRandomBigInt = new BigInteger(bigEnd.subtract(bigStart).bitLength(), ran);
        return aRandomBigInt.subtract(bigStart.negate());
    }

    @Override
    public Object generateDouble() {
        return (Double.parseDouble(column.getEnd()) - Double.parseDouble(column.getBegin()) + 1)
                * ran.nextDouble() + Double.parseDouble(column.getBegin());
    }

    @Override
    protected Object generateJson() {
        return "'{\"" + genString(genLong(Long.parseLong(column.getBegin())/2,
                Long.parseLong(column.getEnd())/2), true, ran, true) + "\": \"" +
                genString(genLong(Long.parseLong(column.getBegin())/2,
                        Long.parseLong(column.getEnd())/2), false, ran, true) + "\"}'";
    }

    @Override
    protected Object generateNumeric() {
        return (Double.parseDouble(column.getEnd()) - Double.parseDouble(column.getBegin()) + 1)
                * ran.nextDouble() + Double.parseDouble(column.getBegin());
    }

    @Override
    protected Object generateReal() {
        return (Float.parseFloat(column.getEnd()) - Float.parseFloat(column.getBegin()) + 1)
                * ran.nextFloat() + Float.parseFloat(column.getBegin());
    }

    @Override
    protected Object generateText() {
        return "'" + genString(genLong(Long.parseLong(column.getBegin()),
                Long.parseLong(column.getEnd())), false, ran, true) + "'";
    }

    @Override
    protected Object generateBoolean() {
        return Math.random() < 0.5;
    }

    @Override
    protected Object generateBit() {
        return "B'"+ genString(Long.parseLong(column.getEnd()), true, ran, false) +"'::bit(" + column.getEnd() + ")";
    }

    private long genLong(long min, long max) {
        return min + (long)(Math.random() * (max - min + 1));
    }

    private String genString(long ind, boolean isOneWord, SecureRandom ran, boolean isChar) {
        StringBuilder sb = new StringBuilder();
        boolean isPrev = true;
        for (int i = 0; i < ind; i++) {
            if (isChar) {
                if (!isOneWord && !isPrev && i % (ran.nextInt(10) + 1) == 2) {
                    sb.append(' ');
                    isPrev = true;
                } else {
                    sb.append((char)(ran.nextInt(26) + 'a'));
                    isPrev = false;
                }
            } else {
                sb.append(ran.nextInt(2));
            }
        }
        return sb.toString();
    }

    @Override
    public String getName() {
        return "RANDOM";
    }
}

package cz.startnet.utils.pgdiff.schema;

import java.util.List;

/**
 * Database schema utilities.
 * 
 * @author Alexander Levhsa
 */
public class PgDbUtils {

	/**
	 * Compares sizes first and does List.equals(List)
	 * only if sizes match.
	 * 
	 * @param left List1
	 * @param right List2
	 * @return true is Lists are equal
	 */
	public static boolean listsEqual(
			final List<?> left, final List<?> right) {
		boolean eq = (left.size() == right.size() && left.equals(right));
		// DEBUG output
		// if(!eq) { System.out.println(left.get(0)); }
		return eq;
	}
}

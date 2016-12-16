package blatis;

import blatis.operator.parser.OperatorParser;
import blatis.pipe.FilterPipe;
import blatis.pipe.IPipe;
import blatis.row.IRowAccessor;
import blatis.row.TypedRowAccessor;

/**
 * Created by bkputnam on 12/15/16.
 */
public class StdPipes {
	public static IPipe filter(String filter) {
		return new FilterPipe(filter);
	}
}

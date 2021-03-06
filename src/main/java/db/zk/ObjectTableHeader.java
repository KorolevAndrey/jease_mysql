/*
    Copyright (C) 2016 maik.jablonski@jease.org

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package db.zk;

import java.util.Comparator;

import db.util.Natural;

import org.zkoss.zul.Listhead;
import org.zkoss.zul.Listheader;

public class ObjectTableHeader<E> extends Listhead {

	public ObjectTableHeader(final ObjectTableModel<E> model) {
		String[] cols = model.getColumns();
		for (int i = 0; i < cols.length; i++) {
			final int col = i;
			Listheader listheader = new Listheader(cols[col]);
			listheader.setHflex("" + model.getProportions()[col]);
			if (model.isSortable()) {
				listheader.setSortAscending(new Comparator<E>() {
					public int compare(E o1, E o2) {
						return compareValues(model.getCheckedValue(o1, col),
								model.getCheckedValue(o2, col));
					}
				});
				listheader.setSortDescending(new Comparator<E>() {
					public int compare(E o1, E o2) {
						return -compareValues(model.getCheckedValue(o1, col),
								model.getCheckedValue(o2, col));
					}
				});
			}
			appendChild(listheader);
		}
	}

	public int compareValues(Object o1, Object o2) {
		return Natural.compare(ObjectConverter.convert(o1),
				ObjectConverter.convert(o2));
	}
}

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

import org.zkoss.zul.Hbox;
import org.zkoss.zul.Html;
import org.zkoss.zul.Image;

public class Help extends Hbox {

	public Help(String msg) {
		Popup popup = new Popup(new Html(msg.replace("\n", "<br />")));

		Image image = new Image(Images.HelpBrowser);
		image.setStyle("cursor:pointer;");
		image.setPopup(popup);

		appendChild(image);
		appendChild(popup);
	}
}
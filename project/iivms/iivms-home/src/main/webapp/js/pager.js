function PagedList() {
	this.total = 0;//总记录
	this.page = 0;//总页数
	this.limit = 50;//每页显示记录数
	this.start = 0;//开始索引	
	this.current = 0;//当前页
	this.getPageToolBar = _getPageToolBar;
}
function _getPageToolBar() {
	var u = this;
	var q = u.total;
	var l = u.limit;
	if (u.total > 0) {
		u.page = Math.ceil(q / l);//总数除以每页显示数
		u.current = u.start / l + 1;//当前为第几页
	}
	var m = u.current;
	var j = u.page;
	var r = "";
	if (j > 0) {
		if (m > 1) {
			r += "<a href=\"javascript:void(0);\" class=\"txt-link\" onclick=\"goPage(1);return false;\">\u9996\u9875</a>";
			r += "<a href=\"javascript:void(0);\" class=\"txt-link\" onclick=\"goPage(" + (m - 1) + ");return false;\">\u4e0a\u9875</a>";
		} else {
			r += "<a href=\"javascript:void(0);\" class=\"txt-disabd\">\u9996\u9875</a>";
			r += "<a href=\"javascript:void(0);\" class=\"txt-disabd\">\u4e0a\u9875</a>";
		}
		if (m < j) {
			r += "<a href=\"javascript:void(0);\" class=\"txt-link\" onclick=\"goPage(" + (m + 1) + ");return false;\">\u4e0b\u9875</a>";
			r += "<a href=\"javascript:void(0);\" class=\"txt-link\" onclick=\"goPage(" + j + ");return false;\">\u672b\u9875</a>";
		} else {
			r += "<a href=\"javascript:void(0);\" class=\"txt-disabd\">\u4e0b\u9875</a>";
			r += "<a href=\"javascript:void(0);\" class=\"txt-disabd\">\u672b\u9875</a>";
		}
		r += "<select onchange=\"goPage(this.value);\">";
		for (var h = 1; h <= j; h++) {
			var e = (m == h) ? " selected" : "";
			r += "<option value=\"" + (h) + "\"" + e + ">" + (h) + " / " + j + "</option>";
		}
		r += "</select>";
		r += "<a href=\"javascript:fGoto();\" class=\"txt-disabd\">每页"+l+"条</a>"
	}
	return r;
}


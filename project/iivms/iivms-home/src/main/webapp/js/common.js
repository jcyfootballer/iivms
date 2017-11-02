//js获取项目根路径，如： http://localhost:8083/uimcardprj
function getRootPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    
    return(localhostPaht+projectName);
}

String.prototype.trim = function () {
	return this.replace(/(^[\s　]*)|([\s　]*$)/g, "");
};
String.prototype.byteLength = function () {
	return this.replace(/[^\u0000-\u007f]/g, "aa").length;
};
String.prototype.endWith = function(str) {
	if (str == null || str == "" || this.length == 0
			|| str.length > this.length)
		return false;
	if (this.substring(this.length - str.length) == str)
		return true;
	else
		return false;
	return true;
}

String.prototype.startWith = function(str) {
	if (str == null || str == "" || this.length == 0
			|| str.length > this.length)
		return false;
	if (this.substr(0, str.length) == str)
		return true;
	else
		return false;
	return true;
}

String.prototype.replaceAll = function (s1, s2) {
	return this.replace(new RegExp(s1, "gm"), s2);
}
function embedSVG(id, name, src, width, height) { // IE中清除激活控件虚框 
	var obj = "<embed id=\"" + id + "\" name=\"" + name + "\" src=\"" + src + "\" wmode=\"transparent\" type=\"image/svg+xml\" width=\"" + width + "\" height=\"" + height + "\"></embed>";
	document.write(obj);
}
function resizeIframe(iframeId) {
	if (iframeId) {
		var id = "#" + iframeId;
		var clientH;
		var iframeOffsetTop;
		var contentFrame;
		var contentFrameBody;
		var blankH;
		var contentH;
		var tempH;
		if (document.readyState != "complete") {
			setTimeout(function () {
				resizeIframe(iframeId);
			}, 50);
			return;
		}
		clientH = (document.compatMode && document.compatMode.toLowerCase() == "css1compat") ? document.documentElement.clientHeight : document.body.clientHeight;
		iframeOffsetTop = $(document).find(id).offset().top;
		blankH = clientH - iframeOffsetTop;
		contentFrame = document.getElementById(iframeId);
		contentFrame.height = 400;
		if (contentFrame && !window.opera) {
			if (contentFrame.contentDocument) {
				contentH = contentFrame.contentWindow.document.body.offsetHeight; //FF NS
			} else {
				if (contentFrame.document) {
					contentH = (contentFrame.document.compatMode && contentFrame.document.compatMode.toLowerCase() == "css1compat") ? contentFrame.contentWindow.document.documentElement.scrollHeight : contentFrame.contentWindow.document.body.scrollHeight;
				}
			}
		} else {
			if (contentFrame.contentWindow.document && contentFrame.contentWindow.document.body.scrollHeight) {
				contentH = contentFrame.contentWindow.document.body.scrollHeight;
			}
		}
		tempH = blankH > contentH ? blankH : contentH;
		contentFrame.height = tempH > 300 ? (tempH) : (300);
	}
}
function myOpen(winurl, winname) {
	objWin__ = window.open(winurl, winname, "scrollbars=no,status=yes,resizable=yes,top=0,left=0,width=" + (screen.availWidth - 10) + ",height=" + (screen.availHeight - 30));
	objWin__.focus();
	return true;
}
function getPageSize() {
	var body = (document.compatMode && document.compatMode.toLowerCase() == "css1compat") ? document.documentElement : document.body;
	var bodyOffsetWidth = 0;
	var bodyOffsetHeight = 0;
	var bodyScrollWidth = 0;
	var bodyScrollHeight = 0;
	var pageDimensions = [0, 0];
	pageDimensions[0] = body.clientHeight;
	pageDimensions[1] = body.clientWidth;
	bodyOffsetWidth = body.offsetWidth;
	bodyOffsetHeight = body.offsetHeight;
	bodyScrollWidth = body.scrollWidth;
	bodyScrollHeight = body.scrollHeight;
	if (bodyOffsetHeight > pageDimensions[0]) {
		pageDimensions[0] = bodyOffsetHeight;
	}
	if (bodyOffsetWidth > pageDimensions[1]) {
		pageDimensions[1] = bodyOffsetWidth;
	}
	if (bodyScrollHeight > pageDimensions[0]) {
		pageDimensions[0] = bodyScrollHeight;
	}
	if (bodyScrollWidth > pageDimensions[1]) {
		pageDimensions[1] = bodyScrollWidth;
	}
	return pageDimensions;
}
function commitsave(id) {
	document.getElementById(id).color = "800080";
	document.getElementById(id).style.fontWeight = "bold";
	document.getElementById(id).innerHTML = "\u64cd\u4f5c\u6210\u529f\uff01";
	setTimeout(function () {
		document.getElementById(id).innerHTML = "";
	}, 2000);
}
function commitsavenot(id) {
	document.getElementById(id).color = "FF0000";
	document.getElementById(id).style.fontWeight = "bold";
	document.getElementById(id).innerHTML = "\u64cd\u4f5c\u5931\u8d25\uff01";
	setTimeout(function () {
		document.getElementById(id).innerHTML = "";
	}, 2000);
}
Date.prototype.pattern = function (fmt) {
	var o = {"M+":this.getMonth() + 1, "d+":this.getDate(), "h+":this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, "H+":this.getHours(), "m+":this.getMinutes(), "s+":this.getSeconds(), "q+":Math.floor((this.getMonth() + 3) / 3), "S":this.getMilliseconds()};
	var week = {"0":"\u65e5", "1":"\u4e00", "2":"\u4e8c", "3":"\u4e09", "4":"\u56db", "5":"\u4e94", "6":"\u516d"};
	if (/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}
	if (/(E+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "\u661f\u671f" : "\u5468") : "") + week[this.getDay() + ""]);
	}
	for (var k in o) {
		if (new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
};
/*
* Map对象，实现Map功能
*
*
* size() 获取Map元素个数
* isEmpty() 判断Map是否为空
* clear() 删除Map所有元素
* put(key, value) 向Map中增加元素（key, value) 
* remove(key) 删除指定key的元素，成功返回true，失败返回false
* get(key) 获取指定key的元素值value，失败返回null
* element(index) 获取指定索引的元素（使用element.key，element.value获取key和value），失败返回null
* containsKey(key) 判断Map中是否含有指定key的元素
* containsValue(value) 判断Map中是否含有指定value的元素
* keys() 获取Map中所有key的数组（array）
* values() 获取Map中所有value的数组（array）
*
*/
function Map() {
	this.elements = new Array();

    //获取Map元素个数
	this.size = function () {
		return this.elements.length;
	},

    //判断Map是否为空
	this.isEmpty = function () {
		return (this.elements.length < 1);
	},

    //删除Map所有元素
	this.clear = function () {
		this.elements = new Array();
	},

    //向Map中增加元素（key, value) 
	this.put = function (_key, _value) {
		if (this.containsKey(_key) == true) {
			//if (this.containsValue(_value)) {
				if (this.remove(_key) == true) {
					this.elements.push({key:_key, value:_value});
				}
			//} else {
				//this.elements.push({key:_key, value:_value});
			//}
		} else {
			this.elements.push({key:_key, value:_value});
		}
	},

    //删除指定key的元素，成功返回true，失败返回false
	this.remove = function (_key) {
		var bln = false;
		try {
			for (i = 0; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) {
					this.elements.splice(i, 1);
					return true;
				}
			}
		}
		catch (e) {
			bln = false;
		}
		return bln;
	},

    //获取指定key的元素值value，失败返回null
	this.get = function (_key) {
		try {
			for (i = 0; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) {
					return this.elements[i].value;
				}
			}
		}
		catch (e) {
			return null;
		}
	},

    //获取指定索引的元素（使用element.key，element.value获取key和value），失败返回null
	this.element = function (_index) {
		if (_index < 0 || _index >= this.elements.length) {
			return null;
		}
		return this.elements[_index];
	},

    //判断Map中是否含有指定key的元素
	this.containsKey = function (_key) {
		var bln = false;
		try {
			for (i = 0; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) {
					bln = true;
				}
			}
		}
		catch (e) {
			bln = false;
		}
		return bln;
	},

    //判断Map中是否含有指定value的元素
	this.containsValue = function (_value) {
		var bln = false;
		try {
			for (i = 0; i < this.elements.length; i++) {
				if (this.elements[i].value == _value) {
					bln = true;
				}
			}
		}
		catch (e) {
			bln = false;
		}
		return bln;
	},

    //获取Map中所有key的数组（array）
	this.keys = function () {
		var arr = new Array();
		for (i = 0; i < this.elements.length; i++) {
			arr.push(this.elements[i].key);
		}
		return arr;
	},

    //获取Map中所有value的数组（array）
	this.values = function () {
		var arr = new Array();
		for (i = 0; i < this.elements.length; i++) {
			arr.push(this.elements[i].value);
		}
		return arr;
	};
}

/*
* Set对象，实现Set功能
*
*
* size() 获取Set元素个数
* isEmpty() 判断Set是否为空
* clear() 删除Set所有元素
* push(value) 向Set中增加元素（ value) 
* remove(key) 删除指定key的元素，成功返回true，失败返回false
* element(index) 获取指定索引的元素（使用element.key，element.value获取key和value），失败返回null
* containsValue(value) 判断Set中是否含有指定value的元素
* values() 获取Set中所有value的数组（array）
*
*/
function Set() {
	this.elements = new Array();

    //获取Set元素个数
	this.size = function () {
		return this.elements.length;
	},

    //判断Set是否为空
	this.isEmpty = function () {
		return (this.elements.length < 1);
	},

    //删除Set所有元素
	this.clear = function () {
		this.elements = new Array();
	},

    //向Set中增加元素（value) 
	this.push = function ( _value) {
		if (this.containsValue(_value) == true) {
				//if (this.remove(_value) == true) {
					//this.elements.push(_value);
				//}
		} else {
			this.elements.push(_value);
		}
	},

    //删除指定value的元素，成功返回true，失败返回false
	this.remove = function (_value) {
		var bln = false;
		try {
			for (i = 0; i < this.elements.length; i++) {
				if (this.elements[i] == _value) {
					this.elements.splice(i, 1);
					return true;
				}
			}
		}
		catch (e) {
			bln = false;
		}
		return bln;
	},

    //获取指定索引的元素（使用element.key，element.value获取key和value），失败返回null
	this.element = function (_index) {
		if (_index < 0 || _index >= this.elements.length) {
			return null;
		}
		return this.elements[_index];
	},

    //判断Set中是否含有指定value的元素
	this.containsValue = function (_value) {
		var bln = false;
		try {
			for (i = 0; i < this.elements.length; i++) {
				if (this.elements[i] == _value) {
					bln = true;
				}
			}
		}
		catch (e) {
			bln = false;
		}
		return bln;
	},

    //获取Map中所有value的数组（array）
	this.values = function () {
		var arr = new Array();
		for (i = 0; i < this.elements.length; i++) {
			arr.push(this.elements[i]);
		}
		return arr;
	};
}
function mousePosition(ev) {
	if (ev.pageX || ev.pageY) {
		return {x:ev.pageX, y:ev.pageY};
	}
	return {x:ev.clientX + document.body.scrollLeft - document.body.clientLeft, y:ev.clientY + document.body.scrollTop - document.body.clientTop};
}

function getValueArray(values) {
	if (typeof values == "string") {
		return values.split("|");
	}
	return null;
}

function adjustIframe(iframeId) {
	if (iframeId) {
		var contentFrame = document.getElementById(iframeId);
		if(contentFrame){
			contentFrame.height = 60;
			var contentH = 60;
			if (contentFrame && !window.opera) {
				if (contentFrame.contentDocument) {
					contentH = contentFrame.contentWindow.document.body.offsetHeight; //FF NS
				} else {
					if (contentFrame.document) {
						contentH = (contentFrame.document.compatMode && contentFrame.document.compatMode.toLowerCase() == "css1compat") ? contentFrame.contentWindow.document.documentElement.scrollHeight : contentFrame.contentWindow.document.body.scrollHeight;
					}
				}
			} else {
				if (contentFrame.contentWindow.document && contentFrame.contentWindow.document.body.scrollHeight) {
					contentH = contentFrame.contentWindow.document.body.scrollHeight;
				}
			}
			contentFrame.height = contentH;
			//alert(contentH+"--"+iframeId);
		}
	}
}
//日期js获取日期：前天、昨天、今天、明天、后天
//document.write("前天："+GetDateStr(-2));
//document.write("<br />昨天："+GetDateStr(-1));
//document.write("<br />今天："+GetDateStr(0));
//document.write("<br />明天："+GetDateStr(1));
//document.write("<br />后天："+GetDateStr(2));
//document.write("<br />大后天："+GetDateStr(3));
function GetDateStr(AddDayCount) {
    var dd = new Date();
    dd.setDate(dd.getDate()+AddDayCount);//获取AddDayCount天后的日期
    var y = dd.getFullYear();
    var m = dd.getMonth()+1;//获取当前月份的日期
    var d = dd.getDate();
    return y+"-"+m+"-"+d;
}

function GetDateTimeStr(AddDayCount) {
    var dd = new Date();
    dd.setDate(dd.getDate()+AddDayCount);//获取AddDayCount天后的日期
    var y = dd.getFullYear();
    var m = dd.getMonth()+1;//获取当前月份的日期
    var d = dd.getDate();
    var hh = dd.getHours(); //截取小时，即8 
    var mm = dd.getMinutes(); //截取分钟，即34 
    var ss = dd.getTime() % 60000; //获取时间，因为系统中时间是以毫秒计算的， 
    ss = (ss - (ss % 1000)) / 1000; //然后，将得到的毫秒数再处理成秒 
    
    return y+"-"+m+"-"+d+" "+hh+":"+mm+":"+ss;
}

//10 位时间
function switchTimeFormate(time) {
    var dd = new Date();
    dd.setTime(time*1000);//获取AddDayCount天后的日期
    var y = dd.getFullYear();
    var m = dd.getMonth()+1;//获取当前月份的日期
    var d = dd.getDate();
    var hh = dd.getHours(); //截取小时，即8 
    var mm = dd.getMinutes(); //截取分钟，即34 
    var ss = dd.getTime() % 60000; //获取时间，因为系统中时间是以毫秒计算的， 
    ss = (ss - (ss % 1000)) / 1000; //然后，将得到的毫秒数再处理成秒 
    
    return y+"/"+m+"/"+d+" "+hh+":"+mm+":"+ss;
}


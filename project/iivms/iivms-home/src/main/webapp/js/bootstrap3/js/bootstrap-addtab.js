var addTabs = function (obj) {
    id = "tab_" + obj.id;
 
    $(".nav-tabs").children(".active").removeClass("active");
    $("#mainContent").children(".active").removeClass("active");
    //如果TAB不存在，创建一个新的TAB
    if (!$("#" + id)[0]) {
        //固定TAB中IFRAME高度
        mainHeight = $("#mainContent").height();
        //创建新TAB的title
        title = '<li role="presentation" id="tab_' + id + '"><a href="#' + id + '" aria-controls="'+id+'" role="tab" data-toggle="tab"><i class="glyphicon glyphicon-list-alt "  ></i>' + obj.title+'';
        //是否允许关闭
        if (obj.close) {
            title += '<i class=" "  tabclose="' + id + '">&times;</i>';
        }
        title += '</a></li>';
        //是否指定TAB内容
        if (obj.content) {
            content = '<div  class="tab-pane" id="' + id + '">' + obj.content + '</div>';
        } else {//没有内容，使用IFRAME打开链接
            content = '<div role="tabpanel" class="tab-pane" id="' + id + '"><iframe id="_' + id + '" src="' + obj.url + '" width="100%" height="' + mainHeight +
                    '" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="yes" allowtransparency="yes"></iframe></div>';
        }
        //加入TABS
        $(".nav-tabs").append(title);
        $("#mainContent").append(content);
    }
     
    //激活TAB
    $("#tab_" + id).addClass('active');
    $("#" + id).addClass('active');
     clickTab();
    //$('.nav-tabs a[href="#'+id+'"]').tab('show');
};
 
var closeTab = function (id) {
    //如果关闭的是当前激活的TAB，激活他的前一个TAB
    if ($(".nav-tabs").children(".active").attr('id') == "tab_" + id) {
    	$('.nav-tabs').children(".active").prev().children().tab('show');
      //  $("#tab_" + id).prev().addClass('active');
      //  $("#" + id).prev().addClass('active');
    }
    //关闭TAB
    $("#tab_" + id).remove();
    $("#" + id).remove();
};

var clickTab=function(){
	// $('.nav-tabs a').click(function (e) { 
	   //   e.preventDefault();//阻止a链接的跳转行为 
	     // $(this).tab('show');//显示当前选中的链接及关联的content 
	   //  alert($(this).attr("href"));
	 //   }) 	
	    $(".nav-tabs ").on("click", "[tabclose]", function (e) {
	        id = $(this).attr("tabclose");
	        closeTab(id);
	    });
}

var getCurrentTab=function(){
	 id = $(".nav-tabs").children(".active").attr('id');
	return id;
}

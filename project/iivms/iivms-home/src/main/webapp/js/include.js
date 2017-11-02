//todo 分解成多个接口，或接受参数的方式，实现加载可配置化，而不是笼统的暴力加载方式，太low

//js获取项目根路径，如： http://localhost:8083/iivms-home
function getRootPath(){
    //获取当前网址，如： http://localhost:8083/iivms-home/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： iivms-home/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8080
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/iivms-home
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    
    return(localhostPaht+projectName);
}

//var ctx = "/iivms-home";
var ctx=getRootPath();

document.write("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
document.write("<meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1' />");

//首先加载样式，保证样式先显示
//样式文件头部
document.write("<link rel='stylesheet' type='text/css' href='"+ ctx +"/css/base.css' />");
document.write("<link rel='stylesheet' type='text/css' href='"+ ctx +"/css/css.css' />");
document.write("<link rel='stylesheet' type='text/css' href='"+ ctx +"/js/bootstrap3/css/bootstrap.min.css' />");
//样式文件尾部
//js文件头部
document.write("<script src='"+ ctx +"/js/jquery/jquery-2.1.3.min.js'></script>");
document.write("<script src='"+ ctx +"/js/bootstrap3/js/bootstrap.min.js'></script>");

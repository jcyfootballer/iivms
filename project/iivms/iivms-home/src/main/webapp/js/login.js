var Login = function () {
    return {
        //main function to initiate the module
        init: function () {
           $('#login-form').bootstrapValidator({
        	 message: 'This value is not valid',
  	         feedbackIcons: {/*input状态样式图片*/
  	             valid: 'glyphicon glyphicon-ok',
  	             invalid: 'glyphicon glyphicon-remove',
  	             validating: 'glyphicon glyphicon-refresh'
  	         },
  	         fields: {/*验证：规则*/
  	        	username: {//验证input项：验证规则
  	                 message: 'The 用户名 is not valid',
  	                 validators: {
  	                     notEmpty: {//非空验证：提示消息
  	                         message: '用户名不能为空'
  	                     }
  	                 }
  	             },
  	           password: {//验证input项：验证规则
	                 message: 'The 密码 is not valid',
	                 validators: {
	                     notEmpty: {//非空验证：提示消息
	                         message: '密码不能为空'
	                     }
	                 }
	             }
  	         }
           })
           .on('success.form.bv', function(e) {//点击提交之后
	         // Prevent form submission
	         e.preventDefault();
	         // Get the form instance
	         var $form = $(e.target);
	         // Get the BootstrapValidator instance
	         var bv = $form.data('bootstrapValidator');
	        // alert($form.name.value);
	         // Use Ajax to submit form data 提交至form标签中的action，result自定义
	         //alert($form.serialize());
		     $.post($form.attr('action'), $form.serialize(), function(result) {
		    	 if(result.status==200){
		    		 callback();
		    	 }else{
		    		// alert(result.msg)
		    		 $('#alertResult').text(result.msg);
		    		 $('.alert-warning', $('.login-form')).removeClass("hide");
		    		 setTimeout(function () { $('.alert-warning', $('.login-form')).addClass("hide");}, 2000);
		    	 }
				},"json");
	         
	     });
        }
    };
}();
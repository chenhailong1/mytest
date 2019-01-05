// 品牌控制器
app.controller('brandController', function ($scope, $controller, baseService) {

    // 指定brandController继承baseController
    // 目的：baseController的$scope中的属性方法 全部给  brandController的$scope
    $controller('baseController', {$scope:$scope});

    //  分页查询品牌
    $scope.search = function (page, rows) {
        // 调用服务层
        baseService.findByPage("/brand/findByPage",
            page, rows,  $scope.searchEntity).then(function(response){
            // 获取响应数据 response.data {total : 100, rows : [{},{},{}]}
            $scope.dataList = response.data.rows;
            // 更新分页指令的总记录数
            $scope.paginationConf.totalItems = response.data.total;
        });
    };


    // 添加或修改品牌
    $scope.saveOrUpdate = function () {
        // 定义请求url (添加)
        var url = "save";
        // 判断id
        if ($scope.entity.id){
            url = "update"; // 修改
        }
        // 调用服务层
        baseService.sendPost("/brand/" + url, $scope.entity)
            .then(function(response){
            // 判断响应数据
            if (response.data){ // true
                // 重新查询数据
                $scope.reload();
            }else{
                alert("添加失败！");
            }
        });
    };

    // 为修改按钮绑定点击事件
    $scope.show = function (entity) {
        // 把entity转化成json字符串
        var jsonStr = JSON.stringify(entity);
        // 把json字符串转化成新的json对象
        $scope.entity = JSON.parse(jsonStr);
    };


    /** 为删除按钮绑定点击事件 */
    $scope.delete = function () {
        if ($scope.ids.length > 0){
            // 调用服务层
            baseService.deleteById("/brand/delete", $scope.ids)
                .then(function(response){
                // 获取响应数据
                if (response.data){ // true
                    // 清空ids数组
                    $scope.ids = [];
                    // 重新加载数据
                    $scope.reload();
                }else{
                    alert("删除失败！");
                }
            });
        }else{
            alert("请选择要删除的品牌！");
        }
    };


});
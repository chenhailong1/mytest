// 定义基础的控制器
app.controller('baseController', function ($scope) {

    // 定义分页指令需要的配置信息对象
    $scope.paginationConf ={
        currentPage : 1, // 当前页码
        totalItems : 0, // 总记录数
        itemsPerPage : 10, // 页大小
        perPageOptions: [10,15,20], // 页码下拉列表框
        onChange : function () { // 页码改变事件
            $scope.reload();
        }
    };


    // 定义重新加载数据方法
    $scope.reload = function () {
        $scope.search($scope.paginationConf.currentPage,
            $scope.paginationConf.itemsPerPage);
    };

    // 定义ids数组记录用户选中的品牌的id
    $scope.ids = [];

    /** 为checkbox绑定点击事件 */
    $scope.updateSelection = function ($event, id) {
        // $event: angular事件对象
        // $event.target: dom元素
        if ($event.target.checked){ // 选中
            // 往数组中添加元素
            $scope.ids.push(id);
        }else{// 没有选中
            // 获取元素在数组中的索引号
            var idx = $scope.ids.indexOf(id);
            // 根据索引号删除数组元素
            // 第一个参数：元素在数组中的索引号
            // 第二个参数：删除的个数
            $scope.ids.splice(idx, 1);
        }
    };


});
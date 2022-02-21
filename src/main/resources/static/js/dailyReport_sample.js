$(function(){
    var result = ""; 

    $.ajax({ 
        type: "get", 
        url: "/account/retrieveAll", 
        async: false, //값을 리턴시 해당코드를 추가하여 동기로 변경
        success: function (data) {
            result = data; 
        } });

    $("#jsGrid").jsGrid({
        width: "100%",
        height: "400px",
        inserting: true,
        editing: true,
        sorting: true,
        paging: true,
        pageSize: 5,
        pageButtonCount: 10,
        pageIndex: 1,
        onItemEditing: function(args) {
            console.log(args.itemIndex);
            var test = $("#jsGrid").jsGrid("option", "data")[args.itemIndex];
            console.log(test);
        },
        data:result,
        fields: [
            { name: "edit", type: "checkbox", title: "수정", sorting: false },
            { name: "email", type: "text", width: 150},
            { name: "phoneNumber", type: "text", width: 50 },
            { type: "control" }
        ]
    });
});

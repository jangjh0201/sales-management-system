var clients = [
  {"store": 2, "e1": 20, "e2": 20, "e3": 30},
  {"store": 3, "e1": 20, "e2": 20, "e3": 30},
];

var stores = [
  { Name: "", Id: 0 },
  { Name: "자사몰", Id: 1 },
  { Name: "네이버", Id: 2 },
  { Name: "카카오", Id: 3 }
];

$("#jsGrid").jsGrid({
  width: "100%",
  height: "650px",
  inserting: true,
  editing: true,
  sorting: true,
  paging: true,
  pageSize: 10,
  pageButtonCount: 10,
  pageIndex: 1,

  onItemEditing: function(args) {
      console.log(args.itemIndex);
      var test = $("#jsGrid").jsGrid("option", "data")[args.itemIndex];
      console.log(test);
  },

  controller:{
      loadData: function(filter) {
          return $.ajax({
              type: "GET",
              url: "/items",
              data: filter
          });
      },
  },

  data: clients,

  fields: [
      { name: "store", type: "select", title:"매출처", width: 50, items: stores, valueField: "Id", textField: "Name" },
      { name: "e1", type: "number", title:"제조비 비율(%)", width: 50 },
      { name: "e2", type: "number", title:"광고비 비율(%)", width: 50 },
      { name: "e3", type: "number", title:"수수료 비율(%)", width: 50 },
      { type: "control" }
  ]
});
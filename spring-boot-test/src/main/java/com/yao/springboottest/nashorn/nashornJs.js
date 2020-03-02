var str = '{\n' +
    '  "hsn":"jd",\n' +
    '  "thirdOrder":"34",\n' +
    '  "sku":[{"skuId":"123864","num":1,"bNeedAnnex":true,"bNeedGift":false,"price":11.76}],\n' +
    '  "name":"张三",\n' +
    '  "province":6,\n' +
    '  "city":350,\n' +
    '  "county":351,\n' +
    '  "town":14000,\n' +
    '  "address":"北京市",\n' +
    '  "zip":"100085",\n' +
    '  "phone":"12345678",\n' +
    '  "mobile":"12345678901",\n' +
    '  "email":"abcde@163.com",\n' +
    '  "remark":"ABC123",\n' +
    '  "submitState":0,\n' +
    '  "doOrderPriceMode":0,\n' +
    '    "promiseDate":1,\n' +
    '  "invoiceState":2,\n' +
    '  "invoiceType":1,\n' +
    '  "selectedInvoiceTitle":5,\n' +
    '  "companyName":"ABC",\n' +
    '  "invoiceContent":1,\n' +
    '  "paymentType":101,\n' +
    '  "isUseBalance":0,\n' +
    '  "invoiceName":"AA",\n' +
    '  "invoicePhone":"12345678901",\n' +
    '  "invoiceProvice":1,\n' +
    '  "invoiceCity":1,\n' +
    '  "invoiceCounty":1,\n' +
    '  "invoiceAddress":"AAA"\n' +
    '}';
print(str);
var json = JSON.parse(str);
var invoiceCity = json.getName("invoiceCity")
print(invoiceCity)
print(json)
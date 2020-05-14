# Stock-Market-News
**a project in course OOP - IT3100** 

``` java
main:
	Stock vnindex = new Stock()
	vnindex.Generate()
```

1. Example:
 - sentence 1: VN-Index mở đầu phiên giao dịch giảm nhẹ 0,17 điểm xuống 953,85 điểm (-0.55%)
 - sentence 2: Chốt phiên giao dịch ngày 23/10, VN-Index giảm gần 14 điểm (tương đương 1,45%), còn 939,68 điểm.
 - sentence 3: Mặc dù khối lượng đã tăng lên trên 20% so với hôm qua nhưng chưa thể kéo Vn-Index đảo chiều.
 - sentence 4: khối lượng giao dịch luôn đứng ở mức cao quanh 70 triệu CP/phiên chính là động lực cho sự đi lên của VN-Index thời gian qua.
 - sentence 5: Chỉ số VN-Index đã xuống mức thấp nhất trong vòng hai năm qua khi nó đã vượt qua mức hỗ trợ chính là đáy trước (366,02 điểm vào ngày 20/6).
	
* Với:
	- date: 23/10/2018
	- open: 953.85
	- close: 939.68
	- vol: 7000k
	- openChange: -0.55%
	- closeChange: 1,45%
	- volChange: 20%
	- longrange: 2 năm	(optional)
	- lastBottom: 366.02	(optional)
	- lastBottomDate: 20/6 (optional)
	- lastTop:	(optional)
	- lastTopDate (optional)
2. Stock:
	- attribute:	date, name, open, close, vol
	- method: openChange(), closeChange(), volChange(), dayDown(), lastBottom()

3. Generate(Stock):
	- Mức độ tăng || giảm của giá? -> dựa vào priceChange
	- Mức độ tăng || giảm của khối lượng giao dịch -> dựa vào volChange
	- Giảm liên tục ? ngày
	- Cao nhất từ ? đỉnh cũ, đáy cũ ?
	- sentence 1: input ?
	- sentence 2: input ?
	- sentence 3: input ?
	- sentence 4: ....
	
	
4. Ví dụ trong file VNEXPRESS classified:
	- decrease: group 7, 19, 93, 120
	- light decrease: 107, 114
	- increase: group 14, 21, 22, 142, 148,
	- week: 115, 556
	- predict: group 75
	- vol: 27, 30
		- Tuy Vn-Index tăng giá, song cũng tương tự như phiên trước, phiên giao dịch sáng nay khối lượng và giá trị giao dịch tiếp tục giảm nhẹ. Vn-Index có phiên giảm thứ 4 liên tiếp vào hôm 22/1, khối lượng tăng cho thấy áp lực bán cao hơn phiên trước đó.
		- 1297: Vn-Index tạm dừng ở 541,42 điểm, tăng 8,42 điểm (1,57%), khối lượng giao dịch đạt 640,080 đơn vị.
		- 7689: Đóng cửa, Vn-Index có phiên tăng điểm thứ 3 liên tiếp cùng khối lượng giao dịch tiếp tục được cải thiện.
		- Vn-Index chọc thủng mức 550 điểm, tạm dừng ở 547,13 đểm, khối lượng giao dịch đạt hơn 9 triệu đơn vị

	- open: 149, 188, 208, 252, 261, 266, 270, 273, 274, 312, 355, 363, 364, 381
		- sàn TP Hồ Chí Minh mở cửa rất suôn sẻ trong buổi sáng nay khi chỉ số Vn-Index mở cửa tại 376,23 điểm, tăng 3,95 điểm, tương đương 0,95%.
		- sàn TP Hồ Chí Minh mở cửa rất suôn sẻ trong buổi sáng nay khi chỉ số Vn-Index mở cửa tại 376,23 điểm, tăng 3,95 điểm, tương đương 0,95%.
		- 2092: Mức mở cửa 315 điểm là giá trị thấp nhất của Vn-Index kể từ ngày 6/2/2006.
	- close: 188, 252, 312, 372, 381

	- liên tục: 491



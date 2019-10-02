<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/index.css">   
<style>a.showmap:hover{cursor: pointer;}</style>
<div class="footer_wrap" align="center"> 
	<div class="footer_holder">
		<div class="con">
			<div class="span-3">
				<div id="span-company" class="sqs-block">
					<div>
						<h2 class="foot_title">company</h2>
						<p class="xans-element- xans-layout xans-layout-footer">
							<span>Company : 퓨즈 서울(FUSE SEOUL)</span> | <span>CEO : 김수정</span><br>
							<span>Business Register : [414-14-00870]</span> <br>
							<span>Tel : 031-8042-2345</span> | <span>Address : 15359 경기도
								안산시 단원구 고잔2길 16 (고잔동) 에머랄드빌딩 409호<br> <font color="red">반품주소지:경기도
									시흥시 소망공원로 236 (정왕동) CJ대한통운 경기시흥공단대리점 퓨즈서울 앞</font>
							</span> <br>
							<span><a class="showMap">오시는 길</a></span>
						</p>
					</div>
				</div>
			</div>
			
			<div class="span-3">
				<div class="sqs-block ">
					<div>
						<h2 class="foot_title">information</h2>
						<p class="xans-element- xans-layout xans-layout-footer ">
							<span>CS Center : 031-8042-2345</span> <br> <span>MON-FRI
								AM 11 ~ PM 5 LUNCH PM 12 ~ 1 SAT,SUN,HOLIDAY OFF</span> <br> <span>농협
								302-1316-2503-81 예금주 김수정(퓨즈서울)</span> <br>
						</p>
					</div>
				</div>
			</div>
			
			<div class="span-3">
				<div class="sqs-block ">
					<div>
						<h2 class="foot_title">privacy</h2>

						<ul class="util">
							<li><a href="/member/agreement.html">Agreement</a></li>
							<li><a href="/member/privacy.html">Privacy</a></li>
							<li><a href="/shopinfo/guide.html">Guide</a></li>
						</ul>
					</div>
				</div>
			</div>

			<div class="span-3">
				<div class="sqs-block ">
					<div class="sns_bottom">
						<h2 class="foot_title">follow</h2>
						<ul>
							<li><a href="#" target="_blank">Face</a></li>
		                    <li><a href="#" target="_blank">Twitter</a></li>
		                    <li><a href="#" target="_blank">Instagram</a></li>
		                    <li><a href="#" target="_blank">Blog</a></li>
		                    <li><a href="#" target="_blank">Kakao</a></li>
						</ul>
						<p style="margin-top: 10px;"
							class="xans-element- xans-layout xans-layout-footer copyright ">
							Copyright © 2018 <strong>FUSE SEOUL</strong> .

						</p>
					</div>
				</div>
			</div>
		
		</div>
	</div>
</div>


<iframe class="mapFrame" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3173.051905991402!2d126.83068095103576!3d37.31759814600388!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b6f039c38ddc7%3A0x8902ec905093a5c9!2s16%20Gojan%202-gil%2C%20Gojan%202(i)-dong%2C%20Danwon-gu%2C%20Ansan-si%2C%20Gyeonggi-do!5e0!3m2!1sen!2skr!4v1569999928474!5m2!1sen!2skr" 
width="600" height="450" style="display: none; border:0;"></iframe></div>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$('.showMap').on({
	mouseover: function(){$('.mapFrame').show();},
		
	mouseout: function(){$('.mapFrame').hide();}
	
});

</script>
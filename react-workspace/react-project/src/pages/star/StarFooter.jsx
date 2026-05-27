export default function ObservatoryFooter() {
  return (
    <footer className="bg-[#0a0f1e] border-t border-white/10 text-white/70">
      <div className="max-w-7xl mx-auto px-8 py-16">
        <div className="grid grid-cols-1 md:grid-cols-5 gap-y-12">
          
          {/* 회사 정보 */}
          <div className="md:col-span-2">
            <div className="flex items-center gap-x-3 mb-6">
              <div className="text-4xl">🪐</div>
              <div className="font-bold text-2xl tracking-tight text-white">청성량 천체 관측소</div>
            </div>
            
            <p className="text-sm leading-relaxed max-w-xs">
              별이 쏟아지는 밤하늘 아래,<br />
              우주를 관측하고 연구하는 공간입니다.
            </p>

            <div className="mt-8 text-xs space-y-1">
              <div>경기도 광주시 초월읍 산수로 1234</div>
              <div>TEL. 031-123-4567</div>
              <div>EMAIL. info@cheongseonglya.kr</div>
            </div>
          </div>

          {/* 링크 컬럼 */}
          <div>
            <div className="font-semibold text-white mb-5">관측소</div>
            <div className="space-y-3 text-sm">
              <a href="#" className="block hover:text-white transition">관측소 소개</a>
              <a href="#" className="block hover:text-white transition">연구 분야</a>
              <a href="#" className="block hover:text-white transition">관측 프로그램</a>
              <a href="#" className="block hover:text-white transition">시설 안내</a>
            </div>
          </div>

          <div>
            <div className="font-semibold text-white mb-5">방문 안내</div>
            <div className="space-y-3 text-sm">
              <a href="#" className="block hover:text-white transition">오는 길</a>
              <a href="#" className="block hover:text-white transition">관측 예약</a>
              <a href="#" className="block hover:text-white transition">주차 안내</a>
              <a href="#" className="block hover:text-white transition">이용 시간</a>
            </div>
          </div>

          <div>
            <div className="font-semibold text-white mb-5">고객지원</div>
            <div className="space-y-3 text-sm">
              <a href="#" className="block hover:text-white transition">자주 묻는 질문</a>
              <a href="#" className="block hover:text-white transition">문의하기</a>
              <a href="#" className="block hover:text-white transition">공지사항</a>
              <a href="#" className="block hover:text-white transition">뉴스레터</a>
            </div>
          </div>
        </div>

        {/* 하단 영역 */}
        <div className="mt-16 pt-8 border-t border-white/10 flex flex-col md:flex-row md:items-center justify-between gap-y-4 text-xs">
          <div>
            © 2026 청성량 천체 관측소. All Rights Reserved.
          </div>
          
          <div className="flex flex-wrap gap-x-6">
            <a href="#" className="hover:text-white transition">개인정보처리방침</a>
            <a href="#" className="hover:text-white transition">이용약관</a>
            <a href="#" className="hover:text-white transition">저작권 안내</a>
          </div>
        </div>
      </div>
    </footer>
  )
}
export default function ObservatoryHeader() {
  return (
    <header className="fixed top-0 left-0 right-0 z-50 bg-[#0a0f1e]/95 backdrop-blur-md border-b border-white/10">
      <div className="max-w-7xl mx-auto px-8 h-20 flex items-center justify-between">
        
        {/* 왼쪽: 로고 + 회사명 */}
        <div className="flex items-center gap-x-3">
          <div className="text-4xl">🪐</div>
          <div>
            <div className="font-bold text-2xl tracking-tight text-white">
              청성량 천체 관측소
            </div>
            <div className="text-[10px] text-white/50 -mt-1 tracking-[2px]">
              CHEONGSEONGLYA ASTRONOMICAL OBSERVATORY
            </div>
          </div>
        </div>

        {/* 오른쪽: 호버 드롭다운 메뉴 */}
        <div className="flex items-center gap-x-10 text-sm font-medium text-white">
          
          {/* 소개 */}
          <div className="group relative">
            <button className="flex items-center gap-x-1 hover:text-[#a5b4fc] transition-colors duration-200">
              소개
              <span className="text-xs mt-0.5">▼</span>
            </button>

            {/* 드롭다운 메뉴 */}
            <div className="absolute right-0 mt-4 w-56 bg-[#111827] border border-white/10 rounded-xl py-2 shadow-2xl 
                            opacity-0 invisible group-hover:opacity-100 group-hover:visible transition-all duration-200 z-50">
              <a href="#" className="block px-5 py-3 text-sm hover:bg-white/5">관측소 소개</a>
              <a href="#" className="block px-5 py-3 text-sm hover:bg-white/5">연구 분야</a>
              <a href="#" className="block px-5 py-3 text-sm hover:bg-white/5">관측 프로그램</a>
              <a href="#" className="block px-5 py-3 text-sm hover:bg-white/5">연혁</a>
            </div>
          </div>

          {/* 가는길 */}
          <div className="group relative">
            <button className="flex items-center gap-x-1 hover:text-[#a5b4fc] transition-colors duration-200">
              가는길
              <span className="text-xs mt-0.5">▼</span>
            </button>

            {/* 드롭다운 메뉴 */}
            <div className="absolute right-0 mt-4 w-64 bg-[#111827] border border-white/10 rounded-xl py-2 shadow-2xl 
                            opacity-0 invisible group-hover:opacity-100 group-hover:visible transition-all duration-200 z-50">
              <div className="px-5 py-2 text-xs text-white/50">경기도 광주시</div>
              <a href="#" className="block px-5 py-3 text-sm hover:bg-white/5">주소 및 오시는 길</a>
              <a href="#" className="block px-5 py-3 text-sm hover:bg-white/5">대중교통 안내</a>
              <a href="#" className="block px-5 py-3 text-sm hover:bg-white/5">주차장 안내</a>
              <a href="#" className="block px-5 py-3 text-sm hover:bg-white/5">문의하기</a>
            </div>
          </div>

        </div>
      </div>
    </header>
  )
}
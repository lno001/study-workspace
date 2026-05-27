export default function MainHero() {
  return (
    <section className="relative h-[92vh] flex items-center justify-center overflow-hidden">
      
      {/* 별이 빛나는 밤하늘 배경 */}
      <div className="absolute inset-0 bg-[#0a0f1e]">
        {/* 별 효과 */}
        <div className="absolute inset-0 bg-[radial-gradient(white_0.9px,transparent_1px)] bg-[length:3.5px_3.5px] opacity-50" />
        <div className="absolute inset-0 bg-[radial-gradient(white_0.6px,transparent_1px)] bg-[length:2px_2px] opacity-30" />
      </div>

      {/* 그라데이션 오버레이 */}
      <div className="absolute inset-0 bg-gradient-to-b from-black/60 via-black/30 to-black/70" />

      {/* 메인 콘텐츠 */}
      <div className="relative z-10 max-w-5xl px-6 text-center">
        <div className="inline-block px-5 py-1.5 rounded-full border border-white/30 text-xs tracking-[3px] mb-6 text-white/80">
          SINCE 2026
        </div>

        <h1 className="text-6xl md:text-7xl lg:text-8xl font-bold tracking-tighter leading-none mb-8">
          별이 쏟아지는<br />밤하늘 아래서
        </h1>

        <p className="max-w-2xl mx-auto text-2xl md:text-3xl text-[#a5b4fc] font-light tracking-wide">
          청성량 천체 관측소
        </p>

        <div className="mt-12">
          <button 
            onClick={() => window.scrollTo({ top: 800, behavior: 'smooth' })}
            className="group inline-flex items-center gap-x-3 px-10 py-4 border border-white/70 hover:bg-white hover:text-black transition-all duration-300 rounded-full"
          >
            <span>관측소 둘러보기</span>
            <span className="group-hover:translate-x-1 transition">↓</span>
          </button>
        </div>
      </div>

      {/* 구석에 별을 가리키는 사람 (이미지 영역) */}
      <div className="absolute bottom-12 right-8 md:right-16 hidden lg:block">
        <div className="relative w-[220px] h-[280px]">
          {/* 사람 실루엣 + 별 가리키는 손 */}
          <div className="absolute bottom-0 right-0 w-48 h-72 bg-gradient-to-t from-white/10 to-transparent rounded-full blur-[2px]" />
          
          {/* 사람 모양 (간단한 실루엣) */}
          <div className="absolute bottom-8 right-6 w-28 h-44 bg-white/10 rounded-[100px_100px_60px_60px] flex items-center justify-center">
            <div className="text-6xl opacity-60">🧍‍♂️</div>
          </div>

          {/* 손으로 별 가리키는 효과 */}
          <div className="absolute top-12 -right-4 text-6xl rotate-12 opacity-80">
            👆
          </div>

          {/* 별 반짝임 효과 */}
          <div className="absolute -top-6 -right-8 text-3xl animate-pulse">✨</div>
          <div className="absolute top-4 -right-2 text-xl animate-pulse delay-300">✧</div>
        </div>
      </div>

      {/* 하단 스크롤 유도 */}
      <div className="absolute bottom-8 left-1/2 -translate-x-1/2 flex flex-col items-center text-xs tracking-[2px] text-white/50">
        SCROLL TO DISCOVER
        <div className="mt-2 w-px h-8 bg-white/30" />
      </div>
    </section>
  )
}
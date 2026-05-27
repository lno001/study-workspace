'use client'

import { useState } from 'react'

export default function LimbusCompanySite() {
  const [mobileMenuOpen, setMobileMenuOpen] = useState(false)

  const sinners = [
    { id: 1, name: "이스마엘", role: "Sinner #8", desc: "복수심에 불타는 선원" },
    { id: 2, name: "돈키호테", role: "Sinner #3", desc: "정의의 기사" },
    { id: 3, name: "홍루", role: "Sinner #6", desc: "우아한 귀족" },
    { id: 4, name: "히스클리프", role: "Sinner #7", desc: "광기에 사로잡힌 복수자" },
    { id: 5, name: "료슈", role: "Sinner #4", desc: "침묵의 검사" },
    { id: 6, name: "파우스트", role: "Sinner #2", desc: "지식의 탐구자" },
  ]

  return (
    <div className="bg-[#0a0a0a] text-white min-h-screen">
      {/* Header */}
      <header className="fixed top-0 left-0 right-0 z-50 bg-black/90 backdrop-blur-md border-b border-red-900">
        <nav className="mx-auto max-w-7xl px-6 flex h-20 items-center justify-between">
          <div className="flex items-center gap-x-3">
            <div className="text-red-600 text-3xl font-black tracking-[4px]">LIMBUS</div>
            <div className="text-[10px] text-red-500 font-mono -mt-1">COMPANY</div>
          </div>

          <div className="hidden md:flex items-center gap-x-10 text-sm font-medium">
            <a href="#story" className="hover:text-red-500 transition">STORY</a>
            <a href="#sinners" className="hover:text-red-500 transition">SINNERS</a>
            <a href="#world" className="hover:text-red-500 transition">THE CITY</a>
            <a href="#news" className="hover:text-red-500 transition">NEWS</a>
          </div>

          <div className="hidden md:block">
            <button className="px-6 py-2 border border-red-600 text-red-500 hover:bg-red-600 hover:text-white transition text-sm font-semibold">
              DOWNLOAD
            </button>
          </div>

          <button onClick={() => setMobileMenuOpen(!mobileMenuOpen)} className="md:hidden text-red-500">
            ☰
          </button>
        </nav>
      </header>

      {/* Hero Section */}
      <section className="relative h-screen flex items-center justify-center pt-20 bg-[radial-gradient(#2a0000_0.8px,transparent_1px)] bg-[length:4px_4px]">
        <div className="absolute inset-0 bg-[linear-gradient(to_bottom,#000000cc_30%,transparent)]" />
        
        <div className="relative z-10 text-center px-6">
          <div className="inline-block px-4 py-1 text-xs tracking-[4px] border border-red-600 text-red-500 mb-6">
            PROJECT MOON
          </div>
          
          <h1 className="text-7xl md:text-8xl font-black tracking-tighter mb-4">
            LIMBUS<br />COMPANY
          </h1>
          <p className="text-2xl text-red-400 font-light tracking-widest mb-10">THE CITY AWAITS</p>
          
          <div className="flex flex-col sm:flex-row gap-4 justify-center">
            <button className="px-10 py-4 bg-red-600 hover:bg-red-700 transition font-semibold text-lg">
              지금 플레이하기
            </button>
            <button className="px-10 py-4 border border-white/70 hover:bg-white hover:text-black transition font-semibold text-lg">
              트레일러 보기
            </button>
          </div>
        </div>

        <div className="absolute bottom-10 text-center">
          <div className="text-xs tracking-[3px] text-red-500">SCROLL TO EXPLORE ↓</div>
        </div>
      </section>

      {/* Story Section */}
      <section id="story" className="max-w-5xl mx-auto px-6 py-24">
        <div className="text-center mb-16">
          <div className="text-red-600 text-sm tracking-[3px]">CHAPTER 00</div>
          <h2 className="text-5xl font-bold mt-3">The Limbus Company</h2>
        </div>
        
        <div className="max-w-3xl mx-auto text-center text-lg text-gray-300 leading-relaxed">
          세상의 끝, '도시'에서 가장 위험한 회사.<br />
          우리는 죄인들을 모아 '황금 가지'를 찾아간다.<br />
          당신도 죄인이 될 준비가 되었는가?
        </div>
      </section>

      {/* Sinners Section */}
      <section id="sinners" className="bg-black py-20 border-y border-red-900">
        <div className="max-w-7xl mx-auto px-6">
          <div className="text-center mb-16">
            <div className="text-red-600 text-sm tracking-[3px]">THE 12 SINNERS</div>
            <h3 className="text-5xl font-bold mt-3">당신의 죄인들을 만나보세요</h3>
          </div>

          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
            {sinners.map((sinner) => (
              <div key={sinner.id} className="group bg-zinc-950 border border-red-900/50 hover:border-red-600 transition p-8">
                <div className="h-48 bg-zinc-900 mb-6 flex items-center justify-center">
                  <div className="text-7xl opacity-30 group-hover:opacity-60 transition">🩸</div>
                </div>
                <div className="text-red-500 text-sm tracking-widest">{sinner.role}</div>
                <div className="text-3xl font-bold mt-2 mb-3 group-hover:text-red-500 transition">{sinner.name}</div>
                <p className="text-gray-400 text-sm leading-relaxed">{sinner.desc}</p>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* The City Section */}
      <section id="world" className="max-w-5xl mx-auto px-6 py-24 text-center">
        <div className="max-w-2xl mx-auto">
          <div className="text-red-600 text-sm tracking-[3px]">THE CITY</div>
          <h3 className="text-5xl font-bold mt-4 leading-none">도시는<br />영원하다</h3>
          <p className="mt-8 text-xl text-gray-300">
            26개의 구역으로 이루어진 거대한 도시.<br />
            여기서 살아남는다는 것은 곧 죄를 짓는 것과 같다.
          </p>
        </div>
      </section>

      {/* CTA Section */}
      <section className="bg-red-950 py-20 text-center">
        <div className="max-w-xl mx-auto px-6">
          <h4 className="text-4xl font-bold">지금 바로<br />림버스 컴퍼니에 합류하세요</h4>
          <p className="mt-6 text-red-400">Steam / Google Play / App Store에서 이용 가능</p>
          
          <button className="mt-10 px-16 py-4 bg-white text-black font-semibold text-lg hover:bg-red-600 hover:text-white transition">
            DOWNLOAD NOW
          </button>
        </div>
      </section>

      {/* Footer */}
      <footer className="bg-black border-t border-red-900 py-16">
        <div className="max-w-7xl mx-auto px-6 grid md:grid-cols-2 gap-y-12">
          <div>
            <div className="flex items-center gap-x-3 mb-6">
              <div className="text-red-600 text-3xl font-black tracking-[3px]">LIMBUS</div>
              <div className="text-red-500 text-xs font-mono">COMPANY</div>
            </div>
            <p className="text-sm text-gray-500 max-w-xs">© Project Moon. All Rights Reserved.</p>
          </div>

          <div className="grid grid-cols-2 md:grid-cols-3 gap-y-10 text-sm">
            <div>
              <div className="font-semibold mb-4 text-red-500">게임</div>
              <div className="space-y-2 text-gray-400">
                <div>다운로드</div>
                <div>시스템 요구사항</div>
                <div>업데이트 내역</div>
              </div>
            </div>
            <div>
              <div className="font-semibold mb-4 text-red-500">커뮤니티</div>
              <div className="space-y-2 text-gray-400">
                <div>공식 디스코드</div>
                <div>트위터</div>
                <div>유튜브</div>
              </div>
            </div>
            <div>
              <div className="font-semibold mb-4 text-red-500">회사</div>
              <div className="space-y-2 text-gray-400">
                <div>Project Moon</div>
                <div>채용</div>
                <div>문의</div>
              </div>
            </div>
          </div>
        </div>

        <div className="mt-16 text-center text-[10px] text-gray-600 tracking-widest">
          THIS IS A FAN-MADE CONCEPT SITE • NOT AFFILIATED WITH PROJECT MOON
        </div>
      </footer>
    </div>
  )
}
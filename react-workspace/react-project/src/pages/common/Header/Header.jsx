'use client'

import { useState } from 'react'

export default function Header() {
  const [mobileMenuOpen, setMobileMenuOpen] = useState(false)

  return (
    <header className="bg-white shadow-sm">
      <nav className="mx-auto max-w-7xl px-6 lg:px-8">
        <div className="flex h-16 items-center justify-between">
          {/* Logo */}
          <div className="flex items-center">
            <a href="#" className="text-2xl font-bold text-indigo-600">
              YourLogo
            </a>
          </div>

          {/* Desktop Menu */}
          <div className="hidden md:flex items-center gap-x-10">
            <a href="#" className="text-sm font-semibold text-gray-700 hover:text-indigo-600 transition">
              제품
            </a>
            <a href="#" className="text-sm font-semibold text-gray-700 hover:text-indigo-600 transition">
              기능
            </a>
            <a href="#" className="text-sm font-semibold text-gray-700 hover:text-indigo-600 transition">
              가격
            </a>
            <a href="#" className="text-sm font-semibold text-gray-700 hover:text-indigo-600 transition">
              회사
            </a>
          </div>

          {/* Right Side Buttons */}
          <div className="hidden md:flex items-center gap-x-4">
            <a href="#" className="text-sm font-semibold text-gray-700 hover:text-gray-900">
              로그인
            </a>
            <a
              href="#"
              className="rounded-full bg-indigo-600 px-5 py-2 text-sm font-semibold text-white hover:bg-indigo-500 transition"
            >
              시작하기
            </a>
          </div>

          {/* Mobile Hamburger */}
          <button
            onClick={() => setMobileMenuOpen(!mobileMenuOpen)}
            className="md:hidden p-2 text-gray-700"
          >
            <svg xmlns="http://www.w3.org/2000/svg" className="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M4 6h16M4 12h16M4 18h16" />
            </svg>
          </button>
        </div>

        {/* Mobile Menu */}
        {mobileMenuOpen && (
          <div className="md:hidden border-t py-4">
            <div className="flex flex-col gap-y-4 px-2">
              <a href="#" className="text-base font-semibold text-gray-700 py-2">제품</a>
              <a href="#" className="text-base font-semibold text-gray-700 py-2">기능</a>
              <a href="#" className="text-base font-semibold text-gray-700 py-2">가격</a>
              <a href="#" className="text-base font-semibold text-gray-700 py-2">회사</a>
              
              <div className="pt-4 border-t flex flex-col gap-y-3">
                <a href="#" className="text-base font-semibold text-gray-700">로그인</a>
                <a href="#" className="rounded-full bg-indigo-600 px-5 py-2.5 text-center text-sm font-semibold text-white">
                  시작하기
                </a>
              </div>
            </div>
          </div>
        )}
      </nav>
    </header>
  )
}
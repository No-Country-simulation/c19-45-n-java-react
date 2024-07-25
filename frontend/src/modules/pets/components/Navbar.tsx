"use client";
import Link from 'next/link'
export const Navbar = () => {
  return (
    <>
      <div className="navbar bg-[#FFAC31]	">
        <div className="navbar-start">
          
          <a className="btn btn-ghost text-xl">PetFriendly</a>
        </div>
        <div className="navbar-center hidden lg:flex">
          {/* <ul className="menu menu-horizontal px-1">
            <li>
              <a>Item 1</a>
            </li>
            <li>
              <details>
                <summary>Parent</summary>
                <ul className="p-2">
                  <li>
                    <a>Submenu 1</a>
                  </li>
                  <li>
                    <a>Submenu 2</a>
                  </li>
                </ul>
              </details>
            </li>
            <li>
              <a>Item 3</a>
            </li>
          </ul> */}
        </div>
        <div className="navbar-end ">
          <Link href='/home' className="btn bg-black text-xl font-bold text-white w-44">home</Link>
        </div>
      </div>
    </>
  );
};

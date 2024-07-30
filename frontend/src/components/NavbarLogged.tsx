import Image from "next/image";
import Link from "next/link";
import { IoLogOutOutline } from "react-icons/io5";

export const NavbarLogged = () => {
  return (
    <nav className="bg-[#FFAC31] p-8">
      <div className="container__appPets flex justify-between items-center">
        <Link href="/ " className="btn btn-ghost text-4xl">
          <Image
            width={200}
            height={100}
            src="/logo.png"
            alt="PetFriendly Logo"
          />
        </Link>
        <div className="flex gap-10 items-center">
          <div className="flex gap-4 items-center">
            <Image
              src="/members/avatar.jpg"
              className="rounded-full"
              width={70}
              height={70}
              alt="Usuario"
            />
            <div>
              <h1 className="text-3xl font-semibold">Usuario</h1>
              <p className="text-xl">usuario@gmail.com</p>
            </div>
          </div>
          <Link href="/mascotas">
            <IoLogOutOutline size={50} />
          </Link>
        </div>
      </div>
    </nav>
  );
};

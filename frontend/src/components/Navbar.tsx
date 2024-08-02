import Image from "next/image";
import Link from "next/link";

export const Navbar = () => {
  return (
    <nav className="bg-[#FFAC31] p-8">
      <div className="container__appPets">
        <Link href="/ " className="btn btn-ghost text-4xl">
          <Image
            width={200}
            height={100}
            src="/logo.png"
            alt="PetFriendly Logo"
          />
        </Link>
      </div>
    </nav>
  );
}

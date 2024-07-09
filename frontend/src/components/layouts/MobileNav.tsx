'use client';
import React from 'react';
import { Sheet, SheetContent, SheetTrigger } from '../ui/sheet';
import { Button } from '../ui/button';
import { AlignJustify, DogIcon } from 'lucide-react';
import Link from 'next/link';
import { Icons } from '../Icons';

export default function MobileNav() {
	const [ open, setOpen ] = React.useState(false);
	return (
		<Sheet open={open} onOpenChange={setOpen}>
			<SheetTrigger asChild>
				<Button
					size="icon"
					variant="ghost"
					className="size-5 hover:bg-transparent focus-visible:bg-transparent focus-visible:ring-0 focus-visible:ring-offset-0 lg:hidden"
				>
					<Icons.menu aria-hidden="true" />
                    <span className="sr-only">Toggle Menu</span>
				</Button>
			</SheetTrigger>
			<SheetContent side="left" className="sm:max-w-xs">
				<nav className="grid gap-6 text-lg font-medium">
					<Link
						href="#"
						className="group flex h-10 w-10 shrink-0 items-center justify-center gap-2 rounded-full bg-primary text-lg font-semibold text-primary-foreground md:text-base"
						onClick={() => setOpen(false)}
					>
						<DogIcon className="h-5 w-5 transition-all group-hover:scale-110" />
						<span className="sr-only">Vercel</span>
					</Link>
				</nav>
			</SheetContent>
		</Sheet>
	);
}

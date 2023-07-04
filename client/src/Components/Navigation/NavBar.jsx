import React from 'react';
import { Link } from 'react-router-dom';

function NavBar() {
	const location = window.location.pathname;
	console.log(location);
	return (
		<nav>
			{/* <div className="flex flex-row justify-end items-center bg-white h-24 pr-10 pb-2">
				<img src={`${process.env.PUBLIC_URL}/assets/logo.png`} alt="logo" className="w-[300px]" />
			</div> */}
			<div className="bg-black w-full h-14 text-white text-center flex flex-row lg:justify-between items-center gap-20 overflow-auto whitespace-nowrap">
				{(localStorage.getItem('userType') === 'ADMIN' || localStorage.getItem('userType') === 'USER') && (
					<>
						<div className="flex">
							<Link to="/profile">
								<div
									className="hover:bg-gray-700 hover:text-gray-200 px-5 py-2 cursor-pointer"
									style={{ color: location === '/profile' ? '#2231d3' : '' }}
								>
									Profile
								</div>
							</Link>
							{localStorage.getItem('userType') === 'ADMIN' && (
								<Link to="/all-users">
									<div
										className="hover:bg-gray-700 hover:text-gray-200 px-5 py-2 cursor-pointer"
										style={{ color: location === '/all-users' ? '#2231d3' : '' }}
									>
										All Users
									</div>
								</Link>
							)}
						</div>
						<div
							onClick={() => {
								localStorage.clear();
								window.location.href = '/';
							}}
							className="hover:bg-gray-700 hover:text-gray-200 px-5 py-2 cursor-pointer"
						>
							Logout
						</div>
					</>
				)}
			</div>
		</nav>
	);
}

export default NavBar;

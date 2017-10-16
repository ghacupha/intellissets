/*******************************************************************************
 * Copyright 2017 edwin.njeru
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.gha.intellissets.intellisets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gha.intellissets.intellisets.model.Asset;
import com.gha.intellissets.intellisets.model.service.AssetService;

@Controller
public class AssetController {
	
	@Autowired private AssetService assetService;
	
	@RequestMapping("/")
	public String startPage(Model model) {
		
		model.addAttribute("assets",assetService.findAll());
		
		return "index";
	}
	
	@RequestMapping("/assets")
	public String showAssets(Model model) {
		
		model.addAttribute("assets",assetService.findAll());
		
		return "assetlist";
	}
	
	@RequestMapping("/asset/new")
	public String newAsset(Model model) {
		
		model.addAttribute("asset", new Asset());
		
		return "assetform";
	}
	
	@RequestMapping(value="/asset", method=RequestMethod.POST)
	public String saveAsset(Asset asset) {
		
		// we update existing asset if it exists
		if(assetService.exists(asset)) {
			
			assetService.updateAsset(asset);
			
		} else {
			
		assetService.addAsset(asset);
		
		}
		
		return "redirect:/asset/"+asset.getId();
	}
	
	@RequestMapping("/asset/edit/{id}")
	public String edit(@PathVariable Integer id, Model model){
		
	    model.addAttribute("asset", assetService.findById(id));
	    
	    return "assetform";
	}
	
    @RequestMapping("/asset/{id}")
    public String showAsset(@PathVariable Integer id, Model model){
    	
        model.addAttribute("asset", assetService.findById(id));
        
        return "assetshow";
    }
    
    @RequestMapping("/asset/delete/{id}")
    public String delete(@PathVariable Integer id,Model model){
    	
        assetService.deleteAsset(id);
        
        // testing if this will hack
        model.addAttribute("assets", assetService.findAll());
        
        return "redirect:/assets";
    }

}
